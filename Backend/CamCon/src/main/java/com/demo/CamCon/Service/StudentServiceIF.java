package com.demo.CamCon.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.Student;


public interface StudentServiceIF {

	List<Student> fetchSubStud( int assId);

	String addFile(MultipartFile upload, long id, int id2) throws IOException;
	
	public Student addStudent(Student student);
	
	public void deleteStudent(int id);

	List<Student> getAll();

	//public Students findById(int id);
}
