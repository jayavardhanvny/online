package org.vinay.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.ConnectionJDBC;

public class LoginService {
	ConnectionJDBC conn = new ConnectionJDBC();
	Connection connection = null;
	
	
	public boolean authenticate(String userId,String password){
		 if(this.validate(userId, password)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validate(String userId,String password){
		connection = conn.getPostgresCon();
		String use="";
		boolean parity = false;
		try{
			String sql = "select userid from userdetails where username = '"+userId+"' and password = '"+password+"'";
			
			
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(!rs.wasNull()){
				while(rs.next()){
					use = rs.getString("userid");
				}
				System.out.println("In If condition "+use);
				parity = true;
			}else{
				System.out.println("Here is the code ");
				parity = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return parity;
	}
	
	public boolean checkUsername(String userId){
		String use="";
		boolean parity = false;
		try{
			String sql = "select userid from userdetails where username = '"+userId+"'";
			
			
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(!rs.wasNull()){
				while(rs.next()){
					use = rs.getString("userid");
				}
				System.out.println("In If condition "+use);
				parity = true;
			}else{
				System.out.println("Here is the code ");
				parity = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return parity;
	}
}
