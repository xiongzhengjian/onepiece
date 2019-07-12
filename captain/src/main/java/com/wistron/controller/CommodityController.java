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

import com.wistron.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.pojo.Commodity;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.CommodityVo;
import com.wistron.pojo.vo.CommodityVos;
import com.wistron.pojo.vo.Limit;
import com.wistron.utils.PageBean;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	private int perPageRows = 15;
	private int currentPage = 1;

	/* Partition of Commodity-------------------->Start */
	/**
	 * Find all bios record
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/commodity")
	public String commodity(HttpSession session, Model model) throws ParseException {
		 int totalRows = commodityService.count();
		 PageBean pageBean = new PageBean(totalRows,perPageRows,currentPage);
		 List<Commodity> list = commodityService.limitFindAll(new Limit(pageBean.getOffset(),pageBean.getPerPageRows()));
		 
		 List<CommodityVo> commdityVos = new ArrayList<CommodityVo>();		
	  	  int size = list.size(); for(int i=0;i<size;i++) { 
	  	  Commodity commodity = list.get(i); 
		  Date start = commodity.getStart();
		  Date end = commodity.getEnd();
		  String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start); 
		  String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end); 
		  String schedule = strStart +" - " + strEnd; 		
		  CommodityVo commodityVo = new CommodityVo(commodity.getCommodity_id(),commodity.getOwner(),commodity.getChassis(),commodity.getPlatform(),commodity.getType(),commodity.getName(),commodity.getPn_sn(),schedule,commodity.getBios_version(),commodity.getImage_build_id(),commodity.getTest_plan(),commodity.getTester());
		  commdityVos.add(commodityVo); 
		  
		}
//		 model.addAttribute("commodityVos",commdityVos);
	  	model.addAttribute("pagebean",pageBean);
		model.addAttribute("vos",commdityVos);

		return "/WEB-INF/views/commodity_record.jsp";
	}
	
	@RequestMapping("/record/commoditypaging")
	public String paging(HttpSession session,Model model,HttpServletRequest request) throws ParseException {
		String str_currentPage = request.getParameter("currentPage");
		currentPage = Integer.parseInt(str_currentPage.trim());		
		return "redirect:./commodity.action";
	}
	
	@RequestMapping("/record/commoditypageshow")
	public String pageshow(HttpSession session,Model model,HttpServletRequest request) throws ParseException {
		String str_perPageRows = request.getParameter("perPageRows");
		//String str_currentPage = request.getParameter("currentPage");
		//currentPage = Integer.parseInt(str_currentPage.trim());	
		perPageRows = Integer.parseInt(str_perPageRows.trim());		
		return "redirect:./commodity.action";
	}

	/**
	 * Jump to add records page
	 * 
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/addcommoditydata")
	public String addbiosdata() {
		return "/WEB-INF/views/new_commodity_records.jsp";
	}

	
	@RequestMapping("/record/insertcommodities")
	public String insertCommodities(HttpSession session, CommodityVos commodityVos) throws ParseException {
//		System.out.println(commodityVos);
		User user = (User) session.getAttribute("session_user");
		if (user == null) {
			return "index.jsp";
		}
		List<CommodityVo> list = commodityVos.getCommodityVos();
		int size = list.size();
		List<Commodity> commodities = new ArrayList<Commodity>();
		for (int i = 0; i < size; i++) {
			CommodityVo commodityVo = list.get(i);
			// Parse Schedule into Start and End dates
			Date[] startAndEnd = splitSchedule(commodityVo.getSchedule());	
			Commodity commodity = new Commodity(user.getEnname(),commodityVo.getChassis(),commodityVo.getPlatform(),commodityVo.getType(),commodityVo.getName(),commodityVo.getPn_sn(),startAndEnd[0],startAndEnd[1],commodityVo.getBios_version(),commodityVo.getImage_build_id(),commodityVo.getTest_plan(),commodityVo.getTester());
			commodities.add(commodity);
		}
		commodityService.insertCommodities(commodities);
		// Please note the suffix .action
		return "redirect:./commodity.action";
	}
	

	@RequestMapping("/record/editcommodity")
	public void editcommodity(@RequestBody CommodityVo commodityVo, HttpSession session, HttpServletResponse response)throws ParseException, IOException {
		User user = (User) session.getAttribute("session_user");
		Date[] startAndEnd = splitSchedule(commodityVo.getSchedule());		
		Commodity commodity = new Commodity(commodityVo.getCommodity_id(),user.getEnname(),commodityVo.getChassis(),commodityVo.getPlatform(),commodityVo.getType(),commodityVo.getName(),commodityVo.getPn_sn(),startAndEnd[0],startAndEnd[1],commodityVo.getBios_version(),commodityVo.getImage_build_id(),commodityVo.getTest_plan(),commodityVo.getTester());
		int status = commodityService.updateCommodity(commodity);
		PrintWriter printWriter = response.getWriter();
		if (status == 1) {
			printWriter.print("success");
		} else {
			printWriter.print("fail");
		}
//		System.out.println(commodity);

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
