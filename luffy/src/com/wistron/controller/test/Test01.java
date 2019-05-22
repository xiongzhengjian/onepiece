package com.wistron.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test01 {
	/**
	 * HTML Test
	 * @return
	 */
	@RequestMapping("/testoFood")
	public ModelAndView  oFood() {
		
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("/html/dashboard_meal.html");
		return modelAndView;
		
	}
	/**
	 * this is a test for login
	 * @return
	 */
	@RequestMapping("/testlogin")
	public ModelAndView login() {
		
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.setViewName("/jsp/test_login.jsp");
		return modelAndView;
	}
}
