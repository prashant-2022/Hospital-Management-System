package com.model;

public class Appointment_Entity {

	private int id;
	private int userId;
	private String name;
	private String gender;
	private String age;
	private String appointDate;
	private String email;
	private String contact;
	private String disease;
	private int doctorId;
	private String address;
//	private String status;
	public Appointment_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment_Entity( int userId, String name, String gender, String age, String appointDate,
			String email, String contact, String disease, int doctorId, String address) {
		super();
		
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.appointDate = appointDate;
		this.email = email;
		this.contact = contact;
		this.disease = disease;
		this.doctorId = doctorId;
		this.address = address;
		//this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	

}
