package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Doctor_Entity;

public class doctor_dao {
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
	public static int registerDoctor(Doctor_Entity d) {
		int status = 0;
		try {
			Connection con=doctor_dao.getConnection();
			String sql="insert into doctor(name,dob,qualification,specilization,email,contact,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecilization());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getContact());
			ps.setString(7, d.getPassword());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Doctor_Entity> getDocotor(){
		List<Doctor_Entity> li = new ArrayList<>();
		try {
			Connection con = doctor_dao.getConnection();
			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Doctor_Entity ob = new Doctor_Entity();
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setDob(rs.getString(3));
				ob.setQualification(rs.getString(4));
				ob.setSpecilization(rs.getString(5));
				ob.setEmail(rs.getString(6));
				ob.setContact(rs.getString(7));
				ob.setPassword(rs.getString(8));
				li.add(ob);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public static Doctor_Entity getDocotorById(int id){
		Doctor_Entity ob = null;
		try {
			Connection con = doctor_dao.getConnection();
			String sql = "select * from doctor where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
			 ob = new Doctor_Entity();
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setDob(rs.getString(3));
				ob.setQualification(rs.getString(4));
				ob.setSpecilization(rs.getString(5));
				ob.setEmail(rs.getString(6));
				ob.setContact(rs.getString(7));
				ob.setPassword(rs.getString(8));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	public static int UpdateDoctor(Doctor_Entity d) {
		int status = 0;
		try {
			Connection con=doctor_dao.getConnection();
			String sql="update doctor set name=?,dob=?,qualification=?,specilization=?,email=?,contact=?,password=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecilization());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getContact());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int deleteDoc(int id) {
		int status = 0;
		try {
			Connection con=doctor_dao.getConnection();
			String sql = "delete from doctor where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Doctor_Entity doctor_login(String email,String password) {
		Doctor_Entity ob = null;
		try {
			Connection con = doctor_dao.getConnection();
			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
			ob=new Doctor_Entity();
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setDob(rs.getString(3));
				ob.setQualification(rs.getString(4));
				ob.setSpecilization(rs.getString(5));
				ob.setEmail(rs.getString(6));
				ob.setContact(rs.getString(7));
				ob.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	public static int getCount() {
		ResultSet rs = null;
		int count=0;
		try {
			Connection con=doctor_dao.getConnection();
			String sql = "select * from doctor";
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
