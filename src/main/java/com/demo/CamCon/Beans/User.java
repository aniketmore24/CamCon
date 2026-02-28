package com.demo.CamCon.Beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "LogIn_Authentication")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role;
	private String username;
	// @Pattern(regexp="^[a-zA-Z][0-9]${8,12}")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRN")
	private Student student;

	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="facultyId") private Faculty faculty;
	 */
	 

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	/*
	 * public Faculty getFaculty() { return faculty; } public void
	 * setFaculty(Faculty faculty) { this.faculty = faculty; }
	 */
	public User() {
		super();
	}

	public User(String role, String username, String password) {
		super();

		this.role = role;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", username=" + username + ", password=" + password + "+student"+student+"]";
	}

}
