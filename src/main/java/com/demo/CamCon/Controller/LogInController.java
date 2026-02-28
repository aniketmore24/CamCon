package com.demo.CamCon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CamCon.Beans.User;
import com.demo.CamCon.Service.LogInServiceIF;
import com.demo.CamCon.Service.LogInServiceImpl;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/LogIn")
public class LogInController {

	@Autowired
	LogInServiceIF lserv;
	
	@PostMapping("/Authentication")
	public ResponseEntity<User> Authentication(@RequestBody User user) {
		
		User verUser=lserv.Auth(user);
		System.out.println(verUser);
		if(verUser!=null)
			return ResponseEntity.ok(verUser);
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
		
	}
}
