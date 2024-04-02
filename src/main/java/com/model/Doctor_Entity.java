package com.model;

public class Doctor_Entity {

	private int id;
	private String name;
	private String dob;
	private String qualification;
	private String specilization;
	private String email;
	private String contact;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Doctor_Entity(String name, String dob, String qualification, String specilization, String email,
			String contact, String password) {
		super();
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.specilization = specilization;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	public Doctor_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor_Entity(int id, String name, String dob, String qualification, String specilization, String email,
			String contact, String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.specilization = specilization;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	

}
