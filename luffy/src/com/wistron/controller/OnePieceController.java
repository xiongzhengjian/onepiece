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
	
	//springMVC可以直接接受pojo类型：要求页面上属性名称必须等于pojo的属性名称
	@RequestMapping("/oFood")
	public String oFood() {	
		return "/WEB-INF/views/oFood.jsp";
	}
	/**
	 * springMvc中默认支持的参数类型:也就是说在controller方法中可以加入这些也可以不加,  加不加看自己需不需要,都行.
	 *HttpServletRequest
	 *HttpServletResponse
	 *HttpSession
	 *Model
	 */
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
	

}

