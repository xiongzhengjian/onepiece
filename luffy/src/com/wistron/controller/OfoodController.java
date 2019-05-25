package com.wistron.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.User;

@Controller
public class OfoodController {
	
	private UserDaoImpl userDao = new UserDaoImpl();
	
	@RequestMapping("/ofood/captain")
	public String home(User user,Model model) {
		int user_id = user.getUser_id();
		User user2 = userDao.findUserById(user_id);
		model.addAttribute("user", user2);
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/ofood/ordermeal")
	public String ordermeal(HttpSession session,User user,Model model) {
		int user_id = (int) session.getAttribute("user_id");
		
		return "";		
	}
}
