package com.wistron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.WatDaoImpl;
import com.wistron.pojo.User;
import com.wistron.pojo.Wat;
import com.wistron.pojo.vo.Limit;
import com.wistron.pojo.vo.WatVo;
import com.wistron.pojo.vo.WatVos;
import com.wistron.utils.PageBean;

@Controller
public class WatController {

	private WatDaoImpl  daoImple = new WatDaoImpl();
	private int perPageRows = 15;
	private int currentPage = 1;
	
	
	@RequestMapping("/record/wat")
	public String wat(HttpSession session, Model model) throws ParseException {
		
		 int totalRows = daoImple.count();
		 PageBean pageBean = new PageBean(totalRows,perPageRows,currentPage);
		 List<Wat> listpojo = daoImple.limitFindAll(new Limit(pageBean.getOffset(),pageBean.getPerPageRows()));
		
		 List<WatVo> listvos = new ArrayList<WatVo>();		
	  	  int size = listpojo.size(); 
	  	  for(int i=0;i<size;i++) { 
	  		Wat pojo = listpojo.get(i); 
			  Date start = pojo.getStart();
			  Date end = pojo.getEnd();
			  String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start); 
			  String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end); 
			  String schedule = strStart +" - " + strEnd; 		
			  WatVo vo = new WatVo(pojo.getWat_id(),pojo.getOwner(),pojo.getChassis(),pojo.getPlatform(),pojo.getDevice_name(),pojo.getPn_sn(),schedule,pojo.getBios_version(),pojo.getImage_build_id(),pojo.getTest_plan(),pojo.getTester());
			  listvos.add(vo);
		  
		}
		 model.addAttribute("pagebean",pageBean);
		 model.addAttribute("vos",listvos);

		return "/WEB-INF/views/wat_record.jsp";
	}
	
	@RequestMapping("/record/watpaging")
	public String paging(HttpSession session,Model model,HttpServletRequest request) throws ParseException {
		String str_currentPage = request.getParameter("currentPage");
		currentPage = Integer.parseInt(str_currentPage.trim());		
		return "redirect:./wat.action";
	}
	
	@RequestMapping("/record/watpageshow")
	public String pageshow(HttpSession session,Model model,HttpServletRequest request) throws ParseException {
		String str_perPageRows = request.getParameter("perPageRows");
		perPageRows = Integer.parseInt(str_perPageRows.trim());		
		return "redirect:./wat.action";
	}

	/**
	 * Jump to add records page
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/addwatdata")
	public String addsoftpaqdata() {
		return "/WEB-INF/views/new_wat_records.jsp";
	}

	
	@RequestMapping("/record/insertwats")
	public String insertMultiple(HttpSession session, WatVos vos) throws ParseException {
//		System.out.println(vos);
		User user = (User) session.getAttribute("session_user");
		if (user == null) {
			return "/index.jsp";
		}
		List<WatVo> list = vos.getWatVos();
		int size = list.size();
		List<Wat> listpojo = new ArrayList<Wat>();
		for (int i = 0; i < size; i++) {
			WatVo vo = list.get(i);
			// Parse Schedule into Start and End dates
			Date[] startAndEnd = splitSchedule(vo.getSchedule());	
			Wat pojo = new Wat(user.getEnname(),vo.getChassis(),vo.getPlatform(),vo.getDevice_name(),vo.getPn_sn(),startAndEnd[0],startAndEnd[1],vo.getBios_version(),vo.getImage_build_id(),vo.getTest_plan(),vo.getTester());
			listpojo.add(pojo);
		}
		daoImple.insertMultiple(listpojo);
		// Please note the suffix .action
		return "redirect:./wat.action";
	}
	

	@RequestMapping("/record/editwat")
	public void update(@RequestBody WatVo vo, HttpSession session, HttpServletResponse response)throws ParseException, IOException {
		User user = (User) session.getAttribute("session_user");
		Date[] startAndEnd = splitSchedule(vo.getSchedule());	
		Wat pojo = new Wat(vo.getWat_id(),user.getEnname(),vo.getChassis(),vo.getPlatform(),vo.getDevice_name(),vo.getPn_sn(),startAndEnd[0],startAndEnd[1],vo.getBios_version(),vo.getImage_build_id(),vo.getTest_plan(),vo.getTester());
		int status = daoImple.update(pojo);
		PrintWriter printWriter = response.getWriter();
		if (status == 1) {
			printWriter.print("success");
		} else {
			printWriter.print("fail");
		}
//		System.out.println(vo);

	}

	/* Partition of Tool or Function-------------------- */
	/**
	 * YYYY/MM/DD 2019/05/09 - 2019/12/28 Parse Schedule(06/13/2019 - 09/18/2019)
	 * into Start(2019-06-13) and End dates(2019-09-18)
	 * 
	 * @return
	 * @throws ParseException
	 */
	private Date[] splitSchedule(String schedule) throws ParseException {
		schedule.replaceAll(" ", "");
		// 2019/05/09 - 2019/12/28
		String[] startAndEnd = schedule.split("-");
		// 2019/05/09
		String startStr = startAndEnd[0];
		// 2019/12/28
		String endStr = startAndEnd[1];
		Date startDate = new SimpleDateFormat("yyyy/MM/dd").parse(startStr);
		Date endDate = new SimpleDateFormat("yyyy/MM/dd").parse(endStr);
		Date[] startDateAndEndDate = { startDate, endDate };
		return startDateAndEndDate;
	}

}
