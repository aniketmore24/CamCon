package com.demo.CamCon.Beans;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assignment1")
public class LoadFile {

	@Id
	private String id;
	private String description;
	private Date date;
    private byte[] file;
    private String filetype;
    private String fileName;
    private String fileSize;
	private int moduleId;
    
    
    
    public int getModuleId() {
		return moduleId;
	}



	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}



	public LoadFile(String description, Date date, byte[] file, String filetype, String fileName, String fileSize, int moduleId) {
		super();
		this.description = description;
		this.date = date;
		this.file = file;
		this.filetype = filetype;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.moduleId = moduleId;
	}
    
    
    
	public LoadFile(String id,String fileName, Date date) {
		super();
		this.id=id;
		this.date = date;
		this.fileName = fileName;
	}



	public LoadFile() {
		super();
	}


	public String getId() {
		return id;
	}

	public String getFileSize() {
		return fileSize;
	}


	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public String toString() {
		return "LoadFile [id=" + id + ", description=" + description + ", date=" + date + ", file="
				+ Arrays.toString(file) + ", filetype=" + filetype + ", fileName=" + fileName + ", fileSize=" + fileSize
				+ ", moduleId=" + moduleId + "]";
	}


	

   

}
