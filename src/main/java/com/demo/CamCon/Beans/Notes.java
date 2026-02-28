package com.demo.CamCon.Beans;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "notes")
public class Notes {
	
	@Id
	private String notesId;
	private String notesName;
	private Date date;
	private String fileType;
	private String fileSize;
	 private String fileName;
	 private byte[] file;
	 private int moduleId;
	 private String type;

		public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*
		 * @OneToOne
		 * 
		 * @JoinColumn(name="moduleId") private Module module;
		 */
	public Notes() {
		super();
	}
	
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Notes(String type,String filename, String notesName, Date date, String fileType, String fileSize, byte[] file,
			int moduleId) {
		super();
		this.notesId = notesId;
		this.notesName = notesName;
		this.date = date;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.file = file;
		this.moduleId = moduleId;
		this.type=type;
		this.fileName=filename;
	}

	public Notes(String notesId, String filename, Date uploadDate) {
		this.notesId=notesId;
		this.fileName=filename;
		this.date = uploadDate;
		
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
	public String getNotesId() {
		return notesId;
	}
	public void setNotesId(String notesId) {
		this.notesId = notesId;
	}
	public String getNotesName() {
		return notesName;
	}
	public void setNotesName(String notesName) {
		this.notesName = notesName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getModule() {
		return moduleId;
	}
	public void setModule(int moduleId) {
		this.moduleId = moduleId;
	}

	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Notes [notesId=" + notesId + ", notesName=" + notesName + ", date=" + date + ", fileType=" + fileType
				+ ", fileSize=" + fileSize + ", fileName=" + fileName + ", file=" + Arrays.toString(file)
				+ ", moduleId=" + moduleId + ", type=" + type + "]";
	}

	
	
	
	
	
}
