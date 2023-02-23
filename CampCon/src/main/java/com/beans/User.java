package com.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(uniqueConstraints= {
		@UniqueConstraint(name="UniqueUname", columnNames = { "uname" })
})
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	
	private String uname;
	private String password;
	private String role;
	
	
	public User(String uname, String password, String role) {
		super();
		this.uname = uname;
		this.password = password;
		this.role = role;
	}


	public User() {
		super();
	}


	/*
	 * public int getUid() { return uid; }
	 * 
	 * 
	 * public void setUid(int uid) { this.uid = uid; }
	 * 
	 * 
	 * public String getUname() { return uname; }
	 * 
	 * 
	 * public void setUname(String uname) { this.uname = uname; }
	 * 
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * 
	 * public String getRole() { return role; }
	 * 
	 * 
	 * public void setRole(String role) { this.role = role; }
	 */


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	

}
