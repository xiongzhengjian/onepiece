package com.wistron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistron.dao.MealDaoImpl;
import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.Meal;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.Mealvo;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.pojo.vo.Ordersubmit;
import com.wistron.pojo.vo.Ordersubmitvo;

@Controller
public class OfoodController {
	
	private MealDaoImpl mealDao = new MealDaoImpl();
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
	 * Today's reservation information
	 * listorderSituation = listOrderSituationStep1 + listOrderSituationStep2
	 */
	@RequestMapping("/ofood/ordersituation")
	@ResponseBody
	public void orderSituation() {
		List<OrderSituation> listorderSituation  = new ArrayList<OrderSituation>();
		List<OrderSituation> listOrderSituationStep1 = userDao.orderSituationStep1();
		List<OrderSituation> listOrderSituationStep2 = userDao.orderSituationStep2();
		
		for(int i=0;i<listOrderSituationStep1.size();i++) {
			OrderSituation orderSituationStep1 = listOrderSituationStep1.get(i);
			OrderSituation orderSituationStep2 = listOrderSituationStep2.get(i);
			OrderSituation orderSituation = new OrderSituation();
			
			orderSituation.setDept(orderSituationStep1.getDept());
			
			int employeesNum = orderSituationStep1.getEmployeesNum();
			orderSituation.setEmployeesNum(employeesNum);
			
			int orderedNum = orderSituationStep2.getOrderedNum();
			orderSituation.setOrderedNum(orderedNum);
			orderSituation.setNotOrderedNum(employeesNum-orderedNum);
			orderSituation.setOrderRate((double)orderedNum/employeesNum);
			
			listorderSituation.add(orderSituation);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * order meal
	 * @param session: get user message
	 * @param orders : the values of order meals 
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/ofood/ordermeal")
	public String ordermeal(HttpSession session,Ordersubmitvo orders ,Model model) throws ParseException {
		//get user form session，then get the user_id
		User user = (User) session.getAttribute("session_user");
		int user_id = user.getUser_id();
		if (user_id<=0) {
			return "/html/error.html";
		}		
		//Multiple pieces of data coming in from the oFood.jsp
		List<Ordersubmit> ordersubmitlist = orders.getOrderlist();
		//Pass the data that needs to be stored to the database through the List
		List<Meal> list = new ArrayList<Meal>();		
		//find all user order situation data that date >= today
		List<Meal> ordered_meals = mealDao.findAll(new Ordersubmit(user_id));		
		//Create a reference variable
		Meal meal = null;		
		//Fetch data from the "ordersubmitlist" and compare the fetched data with the meal data in the database
		for(int i=0;i<ordersubmitlist.size();i++) {			
			Ordersubmit ordersubmit = ordersubmitlist.get(i);			
			Date weekday = ordersubmit.getWeekday();				
			String weekday_format = new SimpleDateFormat("yyyy-MM-dd").format(weekday);
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			//convert ordersubmit date format form yyyy-MM-dd hh:mm:ss  to date format yyyy-MM-dd
			Date weekday_jsp = parse.parse(weekday_format);	
			//to compare
			boolean isContains = isContains(ordered_meals,weekday_jsp);
			if(isContains==true) {//true: Indicates that the 'ordersubmit' does not need to be inserted into the database
				continue;
			}else {
				//create a meal and initialize it
				meal = new Meal("WCQ",user_id);					
				meal.setDate(weekday);	
				//0 breakfast; 1 lunch;  2 dinner
				meal.setType(ordersubmit.getType());
				//0 don't want ; 1 want
				meal.setDecide(ordersubmit.getDecide());		
				list.add(meal);		
			}	
			
			
		}	
			if(list.size()>0) {//Add tips for successful meal plan submission
				mealDao.ofood(list);
				return "/WEB-INF/views/oFood.jsp";	
			}else {//Add tip for "repeat submission, please jump to personal details page if you need to modify" 
				return "/WEB-INF/views/oFood.jsp";	
			}
			
	}
	/**
	 * Respond to customer requests for meal information after the day
	 * @param session
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/ofood/personal")
	public String personal(HttpSession session,Model model) throws ParseException {	
		User user = (User) session.getAttribute("session_user");
		int user_id = user.getUser_id();
		List<Meal> meals_origin = mealDao.findAllLater(new Ordersubmit(user_id));	
		List<Mealvo> meals = new ArrayList<Mealvo>();
		//Format the date and convert it to a String type			
		for(int i=0;i<meals_origin.size();i++) {
			Meal meal = meals_origin.get(i);
			Date date_origin = meal.getDate();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(date_origin);			
			Mealvo mealvo = new Mealvo(meal.getMeal_id(),date,meal.getSite(),meal.getUser(),meal.getType(),meal.getDecide());
			meals.add(mealvo);
		}
		model.addAttribute("meals", meals);
		return "/WEB-INF/views/ofood_personal.jsp";
	}
	
	@RequestMapping("/ofood/change")
	public void change(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = (User) session.getAttribute("session_user");
		int user_id = user.getUser_id();
		String decide = request.getParameter("decide");
		String meal_id = request.getParameter("meal_id");
		String type_page = request.getParameter("type");
		int toUpdateDecide = Integer.parseInt(decide);
		int target_meal_id = Integer.parseInt(meal_id);
		int type = Integer.parseInt(type_page);
		//System.out.println("id:"+target_meal_id+"  user_id:"+user_id+"  decide:"+toUpdateDecide+"  type:"+type);
		Meal meal = new Meal(target_meal_id,user_id,toUpdateDecide);
		int status = mealDao.update(meal);
		PrintWriter printWriter = response.getWriter();
		if(status==1) {
			printWriter.print("success");
		}else {
			printWriter.print("fail");
		}
	}
	
	
	/**
	 * 
	 * @param ordered_meals:  meal data from database which greater than or equal to today
	 * @param weekday_jsp : date of data submitted from the front page
	 * @return true is contain ;false is not contain.
	 * @throws ParseException
	 */
	private boolean isContains(List<Meal> ordered_meals, Date weekday_jsp) throws ParseException {
		List<Date> sources = new ArrayList<Date>();
		for(int j=0;j<ordered_meals.size();j++) {
			Meal ordered_meal = ordered_meals.get(j);
			Date ordered_date = ordered_meal.getDate();
			String ordered_date_format = new SimpleDateFormat("yyyy-MM-dd").format(ordered_date);
			SimpleDateFormat parse_date_mysql = new SimpleDateFormat("yyyy-MM-dd");
			//convert ordered date format form yyyy-MM-dd hh:mm:ss  to date format yyyy-MM-dd
			Date ordered_date_mysql = parse_date_mysql.parse(ordered_date_format);	
			sources.add(ordered_date_mysql);			
			
		}
		//
		if(sources.contains(weekday_jsp)) {
			return true;
		}	
		return false;
	}
}
