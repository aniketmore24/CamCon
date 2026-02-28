package com.demo.CamCon.Service;

import java.util.List;

import com.demo.CamCon.Beans.Faculty;
import com.demo.CamCon.Beans.Student;

public interface FacultyService {
	
	public Faculty addFaculty(Faculty faculty); 
	
	public void deleteFaculty(int id);
	
	public Faculty findById(int id);

	public List<Faculty> fetchAll();

}
