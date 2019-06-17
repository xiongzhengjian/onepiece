package com.wistron.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistron.dao.BiosDaoImpl;
import com.wistron.dao.ProjectDaoImpl;
import com.wistron.pojo.Bios;
import com.wistron.pojo.Project;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.BiosVo;
import com.wistron.pojo.vo.BiosVos;


@Controller
public class ProjectRecordController {
	
	private ProjectDaoImpl projectDao = new ProjectDaoImpl();
	private BiosDaoImpl biosDao = new BiosDaoImpl();
	
	
	
	
/* Partition of Project-------------------->Start  */
	/**
	 * table project
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/record/findChassises")
	public Map<String,List<Project>> findChassises() throws ParseException {	
		Map<String,List<Project>> chassises = new HashMap<String,List<Project>>();
		List<Project> list = projectDao.findChassises();
		chassises.put("chassises", list);
		return chassises;
	}
	/**
	 * table project
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/record/findPlatform")
	public Map<String,List<Project>> findPlatform(@RequestBody Project project) throws ParseException {	
	//public Map<String,List<Project>> findPlatform(@RequestParam ("chassis") String chassis) throws ParseException {	
		Map<String,List<Project>> platforms = new HashMap<String,List<Project>>();
		List<Project> list = projectDao.findPlatform(project.getChassis());
		platforms.put("platforms", list);
		return platforms;
	}
	
/* Partition of BIOS-------------------->Start  */
	/**
	 * Find all bios record
	 * @param session
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/projectrecord")
	public String projectrecord(HttpSession session,Model model) throws ParseException {	
		List<Bios> list = biosDao.findAll();
		List<BiosVo> biosVos = new ArrayList<BiosVo>();
		//bios_id,owner,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester
		int size = list.size();
		for(int i=0;i<size;i++) {
			Bios bios = list.get(i);
			//Set the value of Schedule based on the Start date and End date
			Date start = bios.getStart();
			Date end = bios.getEnd();
			String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start);
			String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end);
			String schedule = strStart + " - " + strEnd;
			BiosVo biosVo = new BiosVo(bios.getBios_id(),bios.getChassis(),bios.getPlatform(),bios.getTest_type(),schedule,bios.getBios_version(),bios.getImage_build_id(),bios.getTest_plan(),bios.getTester());
			biosVos.add(biosVo);
		}
		model.addAttribute("biosVos",biosVos);
		
		return "/WEB-INF/views/project_record.jsp";
	}
	
	/**
	 * Jump to add records page
	 * @param session
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/addbiosdata")
	public String addbiosdata(){			
		return "/WEB-INF/views/new_bios_records.jsp";
	}
	
	/**
	 * Submit the newly added Bios data  
	 * @param biosVos 
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/record/insertBioses")
	public String insertBioses(HttpSession session,BiosVos biosVos) throws ParseException {
		System.out.println(biosVos);		
		User user = (User) session.getAttribute("session_user");
		if(user==null) {
			return "index.jsp";
		}
		 List<BiosVo> list = biosVos.getBiosVos(); int size = list.size();
		 List<Bios> bioses = new ArrayList<Bios>();
		 for(int i=0;i<size;i++) {
			 BiosVo biosVo = list.get(i); 
			 //Parse Schedule into Start and End dates
			 Date[] startAndEnd = splitSchedule(biosVo.getSchedule()); 
			 //String owner, String chassis, String	 platform, String test_type, Date start, Date end,String bios_version, String image_build_id, String test_plan, String tester 
			 //Initialize the BIOS
			 Bios bios = new Bios(user.getEnname(),biosVo.getChassis(),biosVo.getPlatform(),biosVo.getTest_type(),startAndEnd[0],startAndEnd[1],biosVo.getBios_version(),biosVo.getImage_build_id(),biosVo.getTest_plan(),biosVo.getTester());
			 bioses.add(bios);
		 }
		 biosDao.insertBioses(bioses);	
		 //Please note the suffix .action
		 return "redirect:./projectrecord.action";
	}
	
	@RequestMapping("/record/edit")
	public void edit(@RequestBody BiosVo biosVo,HttpSession session,HttpServletResponse response) throws ParseException, IOException {
		User user = (User) session.getAttribute("session_user");
		Date[] startAndEnd = splitSchedule(biosVo.getSchedule()); 
		Bios bios = new Bios(biosVo.getBios_id(),user.getEnname(),biosVo.getChassis(),biosVo.getPlatform(),biosVo.getTest_type(),startAndEnd[0],startAndEnd[1],biosVo.getBios_version(),biosVo.getImage_build_id(),biosVo.getTest_plan(),biosVo.getTester());
		int status = biosDao.edit(bios);
		PrintWriter printWriter = response.getWriter();
		if(status==1) {
			printWriter.print("success");
		}else {
			printWriter.print("fail");
		}
		System.out.println(bios);
		
	}
	
	
	
/* Partition of Tool or Function--------------------  */
	/**
	 * YYYY/MM/DD 2019/05/09 - 2019/12/28
	 * Parse Schedule(06/13/2019 - 09/18/2019) into Start(2019-06-13) and End dates(2019-09-18)
	 * @return 
	 * @throws ParseException 
	 */
	 private Date[] splitSchedule(String schedule) throws ParseException {
		 schedule.replaceAll(" ", "");
		 //2019/05/09 - 2019/12/28
		 String[] startAndEnd = schedule.split("-");		
			 //2019/05/09
			 String startStr = startAndEnd[0];
			 //2019/12/28
			 String endStr = startAndEnd[1];
			 Date startDate = new SimpleDateFormat("yyyy/MM/dd").parse(startStr);
			 Date endDate = new SimpleDateFormat("yyyy/MM/dd").parse(endStr);			 
			 Date[] startDateAndEndDate = {startDate,endDate};		
			 return startDateAndEndDate; 
	 }
	 
	
	
	
	
	
}
