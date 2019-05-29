package com.wistron.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.Ordersubmit;
import com.wistron.pojo.vo.Ordersubmitvo;

@Controller
public class OfoodController {
	
	private UserDaoImpl userDao = new UserDaoImpl();
	/**
	 * go to home page while it is also called captain
	 * @return
	 */
	@RequestMapping("/ofood/captain")
	public String home(HttpSession session) {
		User user = (User) session.getAttribute("session_user");
		if(user==null) {
			return "/html/error.html";
		}
		return "/WEB-INF/views/captain.jsp";
	}
	
	/**
	 * order meal
	 * @param session: get user message
	 * @param orders : the values of order meals 
	 * @param model
	 * @return
	 */
	@RequestMapping("/ofood/ordermeal")
	public String ordermeal(HttpSession session,Ordersubmitvo orders ,Model model) {
		//get user form session
		User user = (User) session.getAttribute("session_user");
		List<Ordersubmit> ordersubmitlist = orders.getOrderlist();
		System.out.println(ordersubmitlist);
		
		
		
		return "/WEB-INF/views/oFood.jsp";		
	}
}
