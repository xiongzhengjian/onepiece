package com.wistron.controller;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistron.dao.ProjectDaoImpl;
import com.wistron.pojo.Project;
import com.wistron.pojo.vo.BiosVo;


@Controller
public class ProjectRecordController {
	
	private ProjectDaoImpl projectDao = new ProjectDaoImpl();
	
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
	public String insertBioses(BiosVo biosVos) {
		System.out.println(biosVos);
		return "/WEB-INF/views/project_record.jsp";
	}
	
	
	
	
	
}
