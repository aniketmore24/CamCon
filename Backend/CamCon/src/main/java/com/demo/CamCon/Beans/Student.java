package com.demo.CamCon.Beans;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {
	
	
	@Id
	private String PRN;
	
	
	private String name;
	
	private String DOB;
	private String email;
	private String Phone;
	private String Qualification;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private User user;
	
	
	
	
	
	public Student() {
		super();
	}
	
	
	
	public String getPRN() {
		return PRN;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student(String pRN, String name, String dOB, String email, String phone, String qualification, User user) {
		
		PRN = pRN;
		this.name = name;
		DOB = dOB;
		this.email = email;
		Phone = phone;
		Qualification = qualification;
		this.user = user;
	}

	public void setPRN(String pRN) {
		PRN = pRN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	
	@Override
	public String toString() {
		return "Students [  PRN=" + PRN + ", name=" + name
				+  ", DOB=" + DOB + ", email=" + email + ", Phone=" + Phone
				+ ", Qualification=" + Qualification + "]";
	}
	
	
	
}
