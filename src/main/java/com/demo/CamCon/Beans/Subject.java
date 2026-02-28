package com.demo.CamCon.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Subject {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subId;
	
	private String sName;
	
	@OneToOne
	@JoinColumn(name="fid")
	private Faculty faculty;

	public Subject(int subId, String sName, Faculty faculty) {
		super();
		this.subId = subId;
		this.sName = sName;
		this.faculty = faculty;
	}

	public Subject() {
		super();
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", sName=" + sName + ", faculty=" + faculty + "]";
	}
	
	
	
}
