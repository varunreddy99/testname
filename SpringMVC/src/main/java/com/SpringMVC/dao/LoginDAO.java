package com.SpringMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
public boolean userAuthentication(String userName, String password) {
		
		boolean isAuthorized = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo?autoReconnect=true&useSSL=false","root","99VAR@un#2");
			PreparedStatement kt = con.prepareStatement("select * from user where userName = ?");
            kt.setString(1,userName);
            ResultSet rs = kt.executeQuery();
			if(rs.next()){
				isAuthorized = true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAuthorized;	
	}


}
