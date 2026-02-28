package com.demo.CamCon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CamCon.Beans.Faculty;
import com.demo.CamCon.Service.FacultyService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	
	@PostMapping("/addfaculty")
	public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
		//return facultyService.addFaculty(faculty);
		return ResponseEntity.ok(facultyService.addFaculty(faculty));
	}
	
	@PostMapping("/deleteFaculty")
	public String deleteFaculty(@RequestBody int id) {
		facultyService.deleteFaculty(id);
		return "Deleted Successfully";
	}
	
	@GetMapping("/findFaculty/{id}")
	public Faculty findById(@PathVariable int id) {
		return facultyService.findById(id);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Faculty>> getAll(){
		
		List<Faculty> flist=facultyService.fetchAll();
		System.out.println(flist);
		
		return ResponseEntity.ok(flist);
		
	}
}
