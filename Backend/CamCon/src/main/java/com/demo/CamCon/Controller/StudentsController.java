package com.demo.CamCon.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.Student;
import com.demo.CamCon.Dao.StudentsDaoIF;
import com.demo.CamCon.Service.StudentServiceIF;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/students")

public class StudentsController {

	@Autowired
	StudentServiceIF studServ;
	
	@PostMapping("/uploadAssgn")
	public ResponseEntity<?> uploadAssgn(@RequestParam("file")MultipartFile file,@RequestParam("StudentId") long id,
			@RequestParam("AssignmentId") int assId) throws IOException
	{
		studServ.addFile(file, id,assId);
		
		//return new ResponseEntity<>(nserv.addFile(file,id), HttpStatus.OK);
		
		return new ResponseEntity<>(studServ.addFile(file, id,assId),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		
		return  ResponseEntity.ok(studServ.getAll());
	}
	
	/*
	 * @GetMapping("/subStud/{id}") public List<Students>
	 * getSubmitedStudents(@PathVariable int id){
	 * 
	 * System.out.println(id); List<Students> slist=studServ.fetchSubStud(id);
	 * System.out.println(slist);
	 * 
	 * 
	 * 
	 * return slist; }
	 */
	
	@GetMapping("/subStud/{id}")
	public Student getSubmitedStudents(@PathVariable int id){
		
		System.out.println(id);
		List<Student> slist=studServ.fetchSubStud(id);
		System.out.println(slist.get(0));
		
	
			return slist.get(0);
		//return new ResponseEntity<>(studServ.fetchSubStud(id),HttpStatus.OK);
	}
	
	@PostMapping("/addstudents")
	public Student addStudent(@RequestBody Student student) {
		System.out.println(student);
		
		return studServ.addStudent(student);
	}
	
	
	@DeleteMapping("/deletestudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		studServ.deleteStudent(id);
	}
	
	
	
}
