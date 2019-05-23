package com.wistron.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.User;

@Controller
public class OnePieceController {
	
	private UserDaoImpl userDao = new UserDaoImpl();
	
	@RequestMapping("/oFood")
	public String testoFood2() {
		
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
	public String login(HttpServletRequest request,Model model) {
		String staffid = request.getParameter("staffid");
		String password =  request.getParameter("password");
		User user = userDao.findUserByStaffid(staffid);
		model.addAttribute("user",user);
		
		System.out.println(staffid+password);
		System.out.println(user);
		return "/WEB-INF/views/captain.jsp";
	}
}

