package com.wistron.controller;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistron.pojo.Project;
import com.wistron.pojo.User;


@Controller
public class ProjectRecordController {
	
	
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
	@RequestMapping("/record/findchassis")
	public Map<String,List<Project>> findchassis() throws ParseException {	
		
			
		return "";
	}
	
	
	
	
	
	
}
