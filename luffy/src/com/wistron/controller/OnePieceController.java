package com.wistron.controller;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("session_user");
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session,HttpServletResponse response,HttpServletRequest request, Uservo uservo,Model model) throws Exception {
		String staffid = uservo.getStaffid();
		String password = uservo.getPassword();
		int remember = uservo.getRemember();
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
		//create a Cookie to save the user name and password if remember equals 1    
		if(remember==1) {
			Cookie cookie_name = new Cookie("username",staffid);
			Cookie cookie_psw = new Cookie("password",password);
			Cookie cookie_remember = new Cookie("remember",""+remember);
			// tomcat下多应用共享
			cookie_name.setPath("/");
			cookie_psw.setPath("/");
			cookie_remember.setPath("/");
			cookie_name.setMaxAge(43200);
			cookie_psw.setMaxAge(43200);
			cookie_remember.setMaxAge(43200);
			response.addCookie(cookie_name);
			response.addCookie(cookie_psw);
			response.addCookie(cookie_remember);
		}else {
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for(Cookie c:cookies) {
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
				}
			}
		}
		
		//login Success! and put the user  in the session 
		session.setAttribute("session_user", user);
		//Figure out the total number of days from the start date to today
		 Date hireDate = user.getHireDate();
		 Date today = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	     int days =  (int) ((today.getTime() - hireDate.getTime())/1000/60/60/24);
	     Uservo uvo = new Uservo();
	     uvo.setDays(days);
	     double years = days/365.0;
	     DecimalFormat df = new DecimalFormat("#.00");
	     String years_str =df.format(years);
	     if(years<1) {
	    	 years_str = "0"+years_str;
	     }
	     uvo.setYears(years_str);
	     session.setAttribute("DandY", uvo);
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
		
		//Figure out the total number of days from the start date to today
		 Date hireDate = newuser.getHireDate();
		 Date today = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	     int days =  (int) ((today.getTime() - hireDate.getTime())/1000/60/60/24);
	     Uservo uvo = new Uservo();
	     uvo.setDays(days);
	     double years = days/365.0;
	     DecimalFormat df = new DecimalFormat("#.00");
	     String years_str =df.format(years);
	     if(years<1) {
	    	 years_str = "0"+years_str;
	     }
	    
	     uvo.setYears(years_str);
	     session.setAttribute("DandY", uvo);
		
		return "/WEB-INF/views/captain.jsp";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Uservo getUser(HttpSession session) {
		User user = (User) session.getAttribute("session_user");
		//set password to null
		Uservo uservo = new Uservo();
		uservo.setName(user.getName());
		uservo.setEnname(user.getEnname());
		uservo.setEmail(user.getEmail());
		Date hireDate = user.getHireDate();
		String hireDate_str = new SimpleDateFormat("yyyy-MM-dd").format(hireDate);
		uservo.setHireDate(hireDate_str);
		return uservo;
	}
	

}

