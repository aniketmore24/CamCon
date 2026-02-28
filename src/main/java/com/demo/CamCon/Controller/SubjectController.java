package com.demo.CamCon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CamCon.Beans.Subject;
import com.demo.CamCon.Service.SubjectServiceIF;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	SubjectServiceIF subserv;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getSubjects(){
		
		return ResponseEntity.ok(subserv.getSubjects());
	}
	
	@PostMapping("/addmodule")
	public ResponseEntity<?> addModule(@RequestBody Subject sub){
		
		return ResponseEntity.ok(subserv.add(sub));
 
	}

}
