package com.wistron.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.MealDaoImpl;
import com.wistron.pojo.Meal;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.Ordersubmit;
import com.wistron.pojo.vo.Ordersubmitvo;

@Controller
public class OfoodController {
	
	private MealDaoImpl mealDao = new MealDaoImpl();
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
		int user_id = user.getUser_id();
		if (user_id<=0) {
			return "/html/error.html";
		}
		//System.out.println(ordersubmitlist);
		Meal meal = null;
		List<Meal> list = new ArrayList<Meal>();
		for(int i=0;i<ordersubmitlist.size();i++) {
			Ordersubmit ordersubmit = ordersubmitlist.get(i);
			//create a meal and initialize it
			meal = new Meal("WCQ",user_id);
			//today next_day ....
			meal.setDate(ordersubmit.getWeekday());
			//0 breakfast; 1 lunch;  2 dinner
			meal.setType(ordersubmit.getType());
			//0 wanted ; 1 want
			meal.setDecide(ordersubmit.getDecide());
			list.add(meal);
		}
		mealDao.ofood(list);
		
		
		
		
		return "/WEB-INF/views/oFood.jsp";		
	}
}
