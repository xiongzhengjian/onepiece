package com.wistron.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.wistron.pojo.vo.BiosVo;
import com.wistron.pojo.vo.BiosVos;


@Controller
public class ProjectRecordController {
	
	private ProjectDaoImpl projectDao = new ProjectDaoImpl();
	private BiosDaoImpl biosDao = new BiosDaoImpl();
	
	@RequestMapping("/record/projectrecord")
	public String projectrecord(HttpSession session,Model model) throws ParseException {			
		return "/WEB-INF/views/project_record.jsp";
	}
	
	@RequestMapping("/record/addbiosdata")
	public String addbiosdata(HttpSession session,Model model) throws ParseException {			
		return "/WEB-INF/views/new_bios_records.jsp";
	}
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
	
	@RequestMapping("/record/insertBioses")
	public String insertBioses(BiosVos biosVos) throws ParseException {
		System.out.println(biosVos);
		
		 List<BiosVo> list = biosVos.getBiosVos(); int size = list.size();
		 List<Bios> bioses = new ArrayList<Bios>();
		 for(int i=0;i<size;i++) {
			 BiosVo biosVo = list.get(i); 
			 //Parse Schedule into Start and End dates
			 Date[] startAndEnd = splitSchedule(biosVo.getSchedule()); 
			 //String owner, String chassis, String	 platform, String test_type, Date start, Date end,String bios_version, String image_build_id, String test_plan, String tester 
			 //Initialize the BIOS
			 Bios bios = new Bios(biosVo.getOwner(),biosVo.getChassis(),biosVo.getPlatform(),biosVo.getTest_type(),startAndEnd[0],startAndEnd[1],biosVo.getBios_version(),biosVo.getImage_build_id(),biosVo.getTest_plan(),biosVo.getTester());
			 bioses.add(bios);
		 }
		 biosDao.insertBioses(bioses);
		 
		return "/WEB-INF/views/project_record.jsp";
	}
	/**
	 * Parse Schedule(06/13/2019 - 09/18/2019) into Start(2019-06-13) and End dates(2019-09-18)
	 * @return
	 * @throws ParseException 
	 */
	 private Date[] splitSchedule(String schedule) throws ParseException {
		 schedule.replaceAll(" ", "");
		 //06/13/2019 - 09/18/2019
		 String[] startAndEnd = schedule.split("-");		
			 //06/13/2019
			 String startStr = startAndEnd[0];
			 //09/18/2019
			 String endStr = startAndEnd[1];
			 //06 13 2019
			 String[] startmdy  = startStr.split("/");
			//09 18 2019
			 String[] endmdy  = endStr.split("/");
			 // 2019-06-13
			 String startymd = startmdy[2]+"-"+startmdy[0]+"-"+startmdy[1];
			 String endymd = endmdy[2]+"-"+endmdy[0]+"-"+endmdy[1];
			 Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startymd.replaceAll(" ", ""));
			 Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endymd.replaceAll(" ", ""));
			 Date[] startDateAndEndDate = {startDate,endDate};		
			 return startDateAndEndDate; 
	 }
	 
	
	
	
	
	
}
