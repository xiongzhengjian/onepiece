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

import com.wistron.service.SoftrollRespinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.Limit;
import com.wistron.pojo.vo.SoftrollRespinVo;
import com.wistron.pojo.vo.SoftrollRespinVos;
import com.wistron.utils.PageBean;

@Controller
public class SoftrollRespinController {

	@Autowired
	private SoftrollRespinService softrollRespinService;
	private int perPageRows = 15;
	private int currentPage = 1;
	
	
	@RequestMapping("/record/softrollrespin")
	public String softrollrespin(HttpSession session, Model model) throws ParseException {
		
		 int totalRows = softrollRespinService.count();
		 PageBean pageBean = new PageBean(totalRows,perPageRows,currentPage);
		 List<SoftrollRespin> listpojo = softrollRespinService.limitFindAll(new Limit(pageBean.getOffset(),pageBean.getPerPageRows()));
		
		 List<SoftrollRespinVo> listvos = new ArrayList<SoftrollRespinVo>();		
	  	  int size = listpojo.size(); 
	  	  for(int i=0;i<size;i++) { 
	  		SoftrollRespin pojo = listpojo.get(i); 
			  Date start = pojo.getStart();
			  Date end = pojo.getEnd();
			  String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start); 
			  String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end); 
			  String schedule = strStart +" - " + strEnd; 		
			  SoftrollRespinVo vo = new SoftrollRespinVo(pojo.getSoftrollrespin_id(),pojo.getOwner(),pojo.getChassis(),pojo.getPlatform(),pojo.getTest_function(),schedule,pojo.getBios_version(),pojo.getImage_build_id(),pojo.getTest_plan(),pojo.getTester());
			  listvos.add(vo);
		  
		}
		 model.addAttribute("pagebean",pageBean);
		 model.addAttribute("vos",listvos);

		return "/WEB-INF/views/softrollrespin_record.jsp";
	}
	
	@RequestMapping("/record/sfrpaging")
	public String paging(HttpSession session,Model model,HttpServletRequest request) throws ParseException {
		String str_currentPage = request.getParameter("currentPage");
		currentPage = Integer.parseInt(str_currentPage.trim());		
		return "redirect:./softrollrespin.action";
	}
	
	@RequestMapping("/record/sfrpageshow")
	public String pageshow(HttpSession session,Model model,HttpServletRequest request) throws ParseException {
		String str_perPageRows = request.getParameter("perPageRows");
		perPageRows = Integer.parseInt(str_perPageRows.trim());		
		return "redirect:./softrollrespin.action";
	}

	/**
	 * Jump to add records page
	 * 
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/addsoftrollrespindata")
	public String addsoftpaqdata() {
		return "/WEB-INF/views/new_softrollrespin_records.jsp";
	}

	
	@RequestMapping("/record/insertsoftrollrespins")
	public String insertMultiple(HttpSession session, SoftrollRespinVos vos) throws ParseException {
//		System.out.println(vos);
		User user = (User) session.getAttribute("session_user");
		if (user == null) {
			return "/index.jsp";
		}
		List<SoftrollRespinVo> list = vos.getSoftrollRespinVos();
		int size = list.size();
		List<SoftrollRespin> listpojo = new ArrayList<SoftrollRespin>();
		for (int i = 0; i < size; i++) {
			SoftrollRespinVo vo = list.get(i);
			// Parse Schedule into Start and End dates
			Date[] startAndEnd = splitSchedule(vo.getSchedule());	
			SoftrollRespin pojo = new SoftrollRespin(user.getEnname(),vo.getChassis(),vo.getPlatform(),vo.getTest_function(),startAndEnd[0],startAndEnd[1],vo.getBios_version(),vo.getImage_build_id(),vo.getTest_plan(),vo.getTester());
			listpojo.add(pojo);
		}
		softrollRespinService.insertMultiple(listpojo);
		// Please note the suffix .action
		return "redirect:./softrollrespin.action";
	}
	

	@RequestMapping("/record/editsoftrollrespin")
	public void update(@RequestBody SoftrollRespinVo vo, HttpSession session, HttpServletResponse response)throws ParseException, IOException {
		User user = (User) session.getAttribute("session_user");
		Date[] startAndEnd = splitSchedule(vo.getSchedule());	
		SoftrollRespin pojo = new SoftrollRespin(vo.getSoftrollrespin_id(),user.getEnname(),vo.getChassis(),vo.getPlatform(),vo.getTest_function(),startAndEnd[0],startAndEnd[1],vo.getBios_version(),vo.getImage_build_id(),vo.getTest_plan(),vo.getTester());
		int status = softrollRespinService.update(pojo);
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
