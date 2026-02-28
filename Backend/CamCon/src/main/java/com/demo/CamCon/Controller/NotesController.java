package com.demo.CamCon.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.CamCon.Beans.LoadFile;
import com.demo.CamCon.Beans.Notes;
import com.demo.CamCon.Service.NotesServiceIF;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins="*")

public class NotesController {

	@Autowired
	NotesServiceIF nserv;
	
	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file,@RequestParam("moduleId") int id) throws IOException {
        System.out.println(id);
		return new ResponseEntity<>(nserv.addFile(file,id), HttpStatus.OK);
    }
	
	
	  @GetMapping("/download/{id}") 
	  public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
		  Notes notes =  nserv.downloadFile(id);
			 
	  
	  return ResponseEntity.ok()
	  .contentType(MediaType.parseMediaType(notes.getFileType() ))
	  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" )
	  .body(new ByteArrayResource(notes.getFile())); }
	  
	
	  
	
	 @GetMapping("/getAll") public ResponseEntity<List<Notes>> getAll() {
	 List<Notes> alist = nserv.addAll();
	 
	 return new ResponseEntity<>(alist, HttpStatus.OK); }
	 
	/*
	 * @GetMapping("/moduleId/{id}") public ResponseEntity<List<Notes>>
	 * getByModuleId(@PathVariable int id) { List<Notes>
	 * nlist=nserv.getNotesById(id);
	 * 
	 * 
	 * return null; }
	 */
	 
	 @GetMapping("/getbyid/{id}")
	 public ResponseEntity<List<Notes>>getById(@PathVariable int id) {
		 List<Notes> nlist =nserv.fetchById(id);
		 System.out.println("in controller");
		 System.out.println(nlist);
		 
		 return ResponseEntity.ok(nlist);

	 	 
	 }
	 
	 
	 @DeleteMapping("/deleteAll")
	 public ResponseEntity<String> deleteAll()
	 {
		 nserv.removeAll();
		 
		 return ResponseEntity.ok("Allfiles deletedsuccessfully");
	 }
	 
	 
}
