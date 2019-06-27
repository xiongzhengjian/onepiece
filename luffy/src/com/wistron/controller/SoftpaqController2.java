package com.wistron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.SoftpaqDaoImpl2;
import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.SoftpaqVo2;

@Controller
public class SoftpaqController2 {

	private SoftpaqDaoImpl2  daoImple = new SoftpaqDaoImpl2();

	/* Partition of Commodity-------------------->Start */
	
	@RequestMapping("/record/softpaq2")
	public String softpaq(HttpSession session, Model model) throws ParseException {
		
		 List<Softpaq2> listpojo = daoImple.findAll();
		 List<SoftpaqVo2> listvos = new ArrayList<SoftpaqVo2>();		
	  	  int size = listpojo.size(); 
	  	  for(int i=0;i<size;i++) { 
		  	  Softpaq2 pojo = listpojo.get(i); 
			  Date start = pojo.getStart();
			  Date end = pojo.getEnd();
			  String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start); 
			  String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end); 
			  String schedule = strStart +" - " + strEnd; 		
			  SoftpaqVo2 vo = new SoftpaqVo2(pojo.getSoftpaq_id(),pojo.getOwner(),schedule,pojo.getSp_number(),pojo.getSoftpaq_title(),pojo.getVersion(),pojo.getPlatform(),pojo.getSptest_tool_status(),pojo.getInstallation_status(),pojo.getFunction_status(),pojo.getProducts_sequence(),pojo.getMark());
			  listvos.add(vo);
		  
		}
		 model.addAttribute("vos",listvos);
		 

		return "/WEB-INF/views/softpaq_record2.jsp";
	}

	/**
	 * Jump to add records page
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @throws ParseException
	 */
//	@RequestMapping("/record/addsoftpaqdata")
//	public String addsoftpaqdata() {
//		return "/WEB-INF/views/new_softpaq_records.jsp";
//	}

	
//	@RequestMapping("/record/insertsoftpaqs")
//	public String insertMultiple(HttpSession session, SoftpaqVos vos) throws ParseException {
////		System.out.println(vos);
//		User user = (User) session.getAttribute("session_user");
//		if (user == null) {
//			return "index.jsp";
//		}
//		List<SoftpaqVo> list = vos.getSoftpaqVos();
//		int size = list.size();
//		List<Softpaq> listpojo = new ArrayList<Softpaq>();
//		for (int i = 0; i < size; i++) {
//			SoftpaqVo vo = list.get(i);
//			// Parse Schedule into Start and End dates
//			Date[] startAndEnd = splitSchedule(vo.getSchedule());	
//			Softpaq pojo = new Softpaq(user.getEnname(),vo.getChassis(),vo.getPlatform(),vo.getSp_number(),vo.getSoftpaq_title(),vo.getVersion(),startAndEnd[0],startAndEnd[1],vo.getBios_version(),vo.getImage_build_id(),vo.getTest_plan(),vo.getTester());
//			listpojo.add(pojo);
//		}
//		daoImple.insertMultiple(listpojo);
//		// Please note the suffix .action
//		return "redirect:./softpaq.action";
//	}
	

	@RequestMapping("/record/editsoftpaq2")
	public void update(@RequestBody SoftpaqVo2 vo, HttpSession session, HttpServletResponse response)throws ParseException, IOException {
		User user = (User) session.getAttribute("session_user");
		Date[] startAndEnd = splitSchedule(vo.getSchedule());	
		Softpaq2 pojo = new Softpaq2(vo.getSoftpaq_id(),user.getEnname(),startAndEnd[0],startAndEnd[1],vo.getSp_number(),vo.getSoftpaq_title(),vo.getVersion(),vo.getPlatform(),vo.getSptest_tool_status(),vo.getInstallation_status(),vo.getFunction_status(),vo.getProducts_sequence(),vo.getMark());
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
