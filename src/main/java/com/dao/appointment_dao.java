package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Appointment_Entity;

public class appointment_dao {
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
	public static int addAppointment(Appointment_Entity e) {
		int status =0;
		try {
			Connection con=appointment_dao.getConnection();
			String sql ="insert into appointment(userId,name,gender,age,appointDate,email,contact,disease,doctorId,address) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getUserId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getGender());
			ps.setString(4, e.getAge());
			ps.setString(5, e.getAppointDate());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getContact());
			ps.setString(8, e.getDisease());
			ps.setInt(9, e.getDoctorId());
			ps.setString(10, e.getAddress());
		//	ps.setString(11, e.getStatus());
			
			status =ps.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
	public static List<Appointment_Entity> getAllApointment(int id){
		List<Appointment_Entity> li = new ArrayList<>();
		try {
			Connection con = appointment_dao.getConnection();
			String sql = "select * from appointment where userId=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Appointment_Entity ob = new Appointment_Entity();
				ob.setId(rs.getInt(1));
				ob.setUserId(rs.getInt(2));
				ob.setName(rs.getString(3));
				ob.setGender(rs.getString(4));
				ob.setAge(rs.getString(5));
				ob.setAppointDate(rs.getString(6));
				ob.setEmail(rs.getString(7));
				ob.setContact(rs.getString(8));
				ob.setDisease(rs.getString(9));
				ob.setDoctorId(rs.getInt(10));
				ob.setAddress(rs.getString(11));
				//ob.setStatus(rs.getString(12));
				li.add(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return li;
	}
	
	public static List<Appointment_Entity> getAllApointmentByDoctorLogin(int doctorId){
		List<Appointment_Entity> li = new ArrayList<>();
		try {
			Connection con = appointment_dao.getConnection();
			String sql = "select * from appointment where doctorId=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, doctorId);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Appointment_Entity ob = new Appointment_Entity();
				ob.setId(rs.getInt(1));
				ob.setUserId(rs.getInt(2));
				ob.setName(rs.getString(3));
				ob.setGender(rs.getString(4));
				ob.setAge(rs.getString(5));
				ob.setAppointDate(rs.getString(6));
				ob.setEmail(rs.getString(7));
				ob.setContact(rs.getString(8));
				ob.setDisease(rs.getString(9));
				ob.setDoctorId(rs.getInt(10));
				ob.setAddress(rs.getString(11));
			//	ob.setStatus(rs.getString(12));
				li.add(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return li;
	}
	
	public static List<Appointment_Entity> getAllApointments(){
		List<Appointment_Entity> li = new ArrayList<>();
		try {
			Connection con = appointment_dao.getConnection();
			String sql = "select * from appointment";
			PreparedStatement ps =con.prepareStatement(sql);
		
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Appointment_Entity ob = new Appointment_Entity();
				ob.setId(rs.getInt(1));
				ob.setUserId(rs.getInt(2));
				ob.setName(rs.getString(3));
				ob.setGender(rs.getString(4));
				ob.setAge(rs.getString(5));
				ob.setAppointDate(rs.getString(6));
				ob.setEmail(rs.getString(7));
				ob.setContact(rs.getString(8));
				ob.setDisease(rs.getString(9));
				ob.setDoctorId(rs.getInt(10));
				ob.setAddress(rs.getString(11));
				//ob.setStatus(rs.getString(12));
				li.add(ob);
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
			String sql = "select * from appointment";
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
