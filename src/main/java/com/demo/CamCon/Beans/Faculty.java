package com.demo.CamCon.Beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Faculty")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class Faculty {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int facultyId;
	
	private String name;
	
	private String module;
	
	private String phoneNo;
	private String emailId;
	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="id") private User user;
	 */
	
	public Faculty() {
		super();
	}

	public Faculty(String name, String module, String phoneNo, String emailId) {
		super();
		this.name = name;
		this.module = module;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", name=" + name + ", module=" + module + ", phoneNo=" + phoneNo
				+ ", emailId=" + emailId +  "]";
	}
	
	
	
	
	
}
