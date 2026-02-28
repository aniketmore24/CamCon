package com.demo.CamCon.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.CamCon.Beans.Faculty;
import com.demo.CamCon.Beans.Student;
import com.demo.CamCon.Dao.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{
	
	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public Faculty addFaculty(Faculty faculty) {
        System.out.println(faculty);		
        return facultyRepository.save(faculty);
	}

	@Override
	public void deleteFaculty(int id) {
		// TODO Auto-generated method stub
		facultyRepository.deleteById(id);
	}

	@Override
	public Faculty findById(int id) {
		// TODO Auto-generated method stub
		return facultyRepository.findById(id).get();
	}

	@Override
	public List<Faculty> fetchAll() {
		
		List<Faculty> flist=facultyRepository.findAll();
		System.out.println(flist);
		
		return flist;
		
	}
	
	

}
