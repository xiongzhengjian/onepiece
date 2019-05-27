package com.wistron.controller;

import javax.servlet.http.HttpServletRequest;
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
	public String ordermeal(HttpSession session,HttpServletRequest request,Model model) {
		//get user form session
		User user = (User) session.getAttribute("session_user");
		//get 
		 String wday = request.getParameter("weekday");
		 int weekday = Integer.parseInt(wday);
		 String tpe = request.getParameter("type");
		 int type = Integer.parseInt(tpe);
		 String deci = request.getParameter("decide");
		 int decide = Integer.parseInt(deci);
		
		System.out.println(user);
		System.out.println(weekday+type+decide);
		
		return "/WEB-INF/views/oFood.jsp";		
	}
}
