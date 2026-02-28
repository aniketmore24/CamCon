package com.demo.CamCon.Beans;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "assignment1")
public class Assignment {

	@Id
	private String id;
	private String description;
	private Date date;
	private Binary file;
	private Subject sub;
	
	public Assignment() {
		super();
	}
	
	public Assignment(String id, String description, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
	}

	public Assignment( String description,  Binary file) {
		super();
	    this.id=id;
		this.description = description;
		this.date = new Date();
		System.out.println(date);
		this.file = file;
	}

	

	public Binary getFile() {
		return file;
	}

	public void setFile(Binary file) {
		this.file = file;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", description=" + description + ", date=" + date + ", file=" + file + "]";
	}

	
}
