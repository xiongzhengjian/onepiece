package com.wistron.controller;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistron.dao.ProjectDaoImpl;
import com.wistron.pojo.Project;
import com.wistron.pojo.User;


@Controller
public class ProjectRecordController {
	
	private ProjectDaoImpl projectDao = new ProjectDaoImpl();
	
	@RequestMapping("/record/projectrecord")
	public String projectrecord(HttpSession session,Model model) throws ParseException {	
		User user = (User) session.getAttribute("session_user");
		int user_id = user.getUser_id();
		//a必须在表中加入user信息，因此需要修改表结构		
		return "/WEB-INF/views/project_record.jsp";
	}//addbiosdata
	
	@RequestMapping("/record/addbiosdata")
	public String addbiosdata(HttpSession session,Model model) throws ParseException {	
		User user = (User) session.getAttribute("session_user");
		int user_id = user.getUser_id();
			
		return "/WEB-INF/views/new_bios_records.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/record/findChassises")
	public Map<String,List<Project>> findChassises() throws ParseException {	
		Map<String,List<Project>> chassises = new HashMap<String,List<Project>>();
		List<Project> list = projectDao.findChassises();
		chassises.put("chassises", list);
		return chassises;
	}
	
	@ResponseBody
	@RequestMapping("/record/findPlatform")
	public Map<String,List<Project>> findPlatform(@RequestBody Project project) throws ParseException {	
	//public Map<String,List<Project>> findPlatform(@RequestParam ("chassis") String chassis) throws ParseException {	
		Map<String,List<Project>> platforms = new HashMap<String,List<Project>>();
		List<Project> list = projectDao.findPlatform(project.getChassis());
		platforms.put("chassises", list);
		return platforms;
	}
	
	
	
	
	
	
}
