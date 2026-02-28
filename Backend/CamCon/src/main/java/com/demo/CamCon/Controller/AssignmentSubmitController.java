package com.demo.CamCon.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.AssignmentSubmit;
import com.demo.CamCon.Beans.Student;
import com.demo.CamCon.Service.AssignmentServiceIF;

import com.demo.CamCon.Service.AssignmentSubmitIF;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/submit")

public class AssignmentSubmitController {

	
	 @Autowired
	 AssignmentSubmitIF asub;
	 
	
	@PostMapping("/uploadassgnsub")
	public ResponseEntity<?> uploadAssgn(@RequestParam("file")MultipartFile file,@RequestParam("PRN") long prn,
			@RequestParam("AssignmentId") String assId) throws IOException
	{
		
		System.out.println("Submit Upload Controller");
		
		return new ResponseEntity<>(asub.addFile(file, prn,assId),HttpStatus.OK);
	}
	

	@GetMapping("/subStud/{assid}")
	public ResponseEntity<List<AssignmentSubmit>> getSubmitedStudents(@PathVariable String assid){
		
		System.out.println(assid);
		List<AssignmentSubmit> slist=asub.fetchSubStud(assid);
		System.out.println(slist);
		
	
			return ResponseEntity.ok(slist);
		//return new ResponseEntity<>(studServ.fetchSubStud(id),HttpStatus.OK);
	}
	
	
	
}
