package com.SpringMVC.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegistrationController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
	
	    int user_Id = 0;
	    String userName = req.getParameter("userName");
	    String password = req.getParameter("password");
	    String phoneNumber = req.getParameter("phoneNumber");

	    String emergencyContactNum = req.getParameter("emergencyContactNum");
        String universityName = req.getParameter("universityName");
        String passportNum = req.getParameter("passportNum");
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo?autoReconnect=true&useSSL=false","root","99VAR@un#2");

			PreparedStatement ps = con.prepareStatement("insert into registrationtable values(?,?,?,?,?,?,?)");
			PreparedStatement k = con.prepareStatement("insert into user values(?,?,?)");
			k.setInt(1,user_Id);
			k.setString(2, userName);
			k.setString(3, password);
		    ps.setInt(1, user_Id);
			ps.setString(2, userName);
            ps.setString(3, password);
            ps.setString(4, phoneNumber);

            ps.setString(5, emergencyContactNum);
            ps.setString(6, universityName);
            ps.setString(7, passportNum);
            int i=ps.executeUpdate();
            int h = k.executeUpdate();
            if(i>0){
            	System.out.println("You are successfully registered");		}
		return null;
	}

}
