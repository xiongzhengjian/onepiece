package com.wistron.controller;
import java.text.ParseException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wistron.pojo.User;


@Controller
public class ProjectRecordController {
	
	
	@RequestMapping("/record/projectrecord")
	public String projectrecord(HttpSession session,Model model) throws ParseException {	
		User user = (User) session.getAttribute("session_user");
		int user_id = user.getUser_id();
		//必须在表中加入user信息，因此需要修改表结构		
		return "/WEB-INF/views/project_record.jsp";
	}
	
	
	
	
	
	
}
