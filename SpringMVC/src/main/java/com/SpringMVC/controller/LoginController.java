package com.SpringMVC.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.SpringMVC.dao.LoginDAO;

public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView("Login");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		LoginDAO dao = new LoginDAO();
		boolean isAuthorized = dao.userAuthentication(userName, password);
		System.out.println("1111111111111111111" + isAuthorized);		 
		if(isAuthorized) {
			 mv = new ModelAndView("Home");
			  }
		else {
			mv= new ModelAndView("Login");
			mv.addObject("msg","username and password are wrong");
		}
		return mv;
	}

}
