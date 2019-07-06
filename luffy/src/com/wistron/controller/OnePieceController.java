package com.wistron.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.Uservo;

@Controller
public class OnePieceController {
	
	private UserDaoImpl userDao = new UserDaoImpl();
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/grandline")
	public String grandline() {			
		return "/WEB-INF/views/grand_line.jsp";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session,User uservo,Model model) throws Exception {
		String staffid = uservo.getStaffid();
		String password = uservo.getPassword();
		//user name or password is empty return the index page
		if(staffid.isEmpty()||password.isEmpty()) {
			return "/index.jsp";
		}
		
		User user = userDao.findUserByStaffid(staffid);
		//the staffid or password is wrong if user is null  
		if(user==null) {
			return "/index.jsp";
		}
		//password mismatch 
		if(!password.equals(user.getPassword())) {
			return "/index.jsp";
		}
		
		//login Success! and put the user  in the session 
		session.setAttribute("session_user", user);
		//Figure out the total number of days from the start date to today
		 Date hireDate = user.getHireDate();
		 Date today = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	     int days =  (int) ((today.getTime() - hireDate.getTime())/1000/60/60/24);
	     session.setAttribute("days", days);
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpSession session,Uservo uservo) throws Exception {
		String originPassword = uservo.getOriginPassword();
		String password = uservo.getPassword();
		User user = (User) session.getAttribute("session_user");
		//don't need to update password branch
		if(originPassword.isEmpty()||password.isEmpty()) {
			user.setName(uservo.getName());
			user.setEnname(uservo.getEnname());
			user.setEmail(uservo.getEmail());
			String hireDate = uservo.getHireDate();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(hireDate);
			user.setHireDate(date);
			userDao.update(user);
			
		//update password branch
		}else {
			String staffid = user.getStaffid();
			//get the user message from database
			User originuser = userDao.findUserByStaffid(staffid);
			String pojo_password = originuser.getPassword();
			//Change the password if the original password is the same as the database password
			if(pojo_password.equals(originPassword)) {
				user.setName(uservo.getName());
				user.setEnname(uservo.getEnname());
				user.setPassword(password);
				user.setEmail(uservo.getEmail());
				String hireDate = uservo.getHireDate();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(hireDate);
				user.setHireDate(date);
				userDao.update(user);
			}
		}
		
		
		String staffid = user.getStaffid();
		User newuser = userDao.findUserByStaffid(staffid);
		session.removeAttribute("session_user");
		session.setAttribute("session_user", newuser);
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(HttpSession session) {
		User user = (User) session.getAttribute("session_user");
		//set password to null
		user.setPassword("");
		return user;
	}
	

}

