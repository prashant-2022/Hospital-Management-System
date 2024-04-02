package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Entity;

public class user_dao {
	public static Connection getConnection() {
		 Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?useSSL=false&allowPublicKeyRetrival=true","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public boolean UserRegister(Entity u) {
		boolean f= false;
		try {
			Connection con=user_dao.getConnection();
			String s = "insert into user(name,email,password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return f;
	}
	public static List<Entity>  login(String email,String password) {
		List<Entity> li= new ArrayList<>();	
		try {
			Connection con=user_dao.getConnection();
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Entity u =new Entity();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				li.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
		
	}
	public static int getCount() {
		ResultSet rs = null;
		int count=0;
		try {
			Connection con=doctor_dao.getConnection();
			String sql = "select * from user";
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
