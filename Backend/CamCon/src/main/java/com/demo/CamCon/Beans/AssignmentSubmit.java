package com.demo.CamCon.Beans;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AssignmentSubmit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ansId;
	
	private Date date;
	private String fileType;
	private String fileSize;
	 private String fileName;
	 private byte[] file;
	 private long prn;
	 private String type;
	 private String objId;
	 
	 
	 
	 
	 
	public AssignmentSubmit() {
		super();
	}
	
	

	public AssignmentSubmit(Date date, String fileType, String fileSize, String fileName, byte[] file, int prn,
			String type) {
		super();
		this.date = date;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.file = file;
		this.prn = prn;
		this.type = type;
	}
	



	public AssignmentSubmit(Object object, Date uploadDate, String ansId) {

	//this.prn=Long.parseLong(object.toString());
	this.ansId= ansId;
	this.prn=(long) object;
	this.date=uploadDate;
	
	}



	public String getAnsId() {
		return ansId;
	}
	public void setAnsId(String ansId) {
		this.ansId = ansId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public long getPrn() {
		return prn;
	}
	public void setPrn(long prn) {
		this.prn = prn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AssignmentSubmit [ansId=" + ansId + ", date=" + date + ", fileType=" + fileType + ", fileSize="
				+ fileSize + ", fileName=" + fileName + ", file=" + Arrays.toString(file) + ", prn=" + prn + ", type="
				+ type + "]";
	} 

	 
	 
}
