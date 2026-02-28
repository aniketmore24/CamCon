package com.demo.CamCon.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;

import com.demo.CamCon.Beans.Assignment;
import com.demo.CamCon.Service.AssignmentServiceIF;

@RestController
@RequestMapping("/Assignment")
@CrossOrigin("*")
public class AssignmentController {

	@Autowired
	AssignmentServiceIF aserv;

	@PostMapping("/Upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {

		System.out.println(file);
		return new ResponseEntity<>(aserv.addFile(file), HttpStatus.OK);

	}

	
	/*
	 * @GetMapping("/Download/{id}") public Binary getAssignment(@PathVariable
	 * String id,Model model) { System.out.println(id); Assignment ass =
	 * aserv.fetchAssignment(id);
	 * 
	 * model.addAttribute("description", ass.getDescription());
	 * model.addAttribute("file",
	 * Base64.getEncoder().encodeToString(ass.getFile().getData()));
	 * 
	 * return ass.getFile(); }
	 */
	 

//	@GetMapping("/Download/{id}")
//	public ResponseEntity<byte[]> getAssignment(@PathVariable String id, Model model) throws IOException {
//		System.out.println(id);
//		Assignment ass = aserv.fetchAssignment(id);
//			File file = ass.getFile();
//		model.addAttribute("description", ass.getDescription());
//		model.addAttribute("file", Base64.getEncoder().encodeToString(ass.getFile().getData()));
//
//		Path file = (Path) (ass.getFile());
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//		headers.setContentLength(Files.size(file));
//		headers.setContentDispositionFormData("attachment", file.getFileName().toString());
//
//		return new ResponseEntity<>(Files.readAllBytes(file), headers, HttpStatus.OK);
//	
		
	
	
	
	//}

	
	@GetMapping("/getAll")
	public ResponseEntity<List<Assignment>> getAll() {
		List<Assignment> alist = aserv.addAll();

		return new ResponseEntity<>(alist, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getAll") public ResponseEntity<List<Assignment>> getAll(){
	 * 
	 * 
	 * return new ResponseEntity<List<Assignment>>(aserv.getAll(),HttpStatus.OK); }
	 */

}
