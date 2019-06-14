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
