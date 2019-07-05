package com.wistron.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.User;

@Controller
public class OnePieceController {
	
	private UserDaoImpl userDao = new UserDaoImpl();
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model,HttpSession session) {
		String staffid = request.getParameter("staffid");
		String password =  request.getParameter("password");
		User user = userDao.findUserByStaffid(staffid);
		//put the user  in the session 
		session.setAttribute("session_user", user);
		//doesn't need put the user in the model,just use session_user at captain.jsp 
		//model.addAttribute("user",user);		
		
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/grandline")
	public String grandline() {			
		return "/WEB-INF/views/grand_line.jsp";
	}

}

