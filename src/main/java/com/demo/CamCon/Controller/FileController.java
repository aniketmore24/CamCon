package com.demo.CamCon.Controller;




import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file,@RequestParam("moduleId") int id ) throws IOException {
        System.out.println(id);
    	return new ResponseEntity<>(fileService.addFile(file, id), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        LoadFile loadFile = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(loadFile.getFiletype() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" )
                .body(new ByteArrayResource(loadFile.getFile()));
    }
    
    @GetMapping("/getAll")
	public ResponseEntity<List<LoadFile>> getAll() {
		List<LoadFile> alist = fileService.addAll();

		return new ResponseEntity<>(alist, HttpStatus.OK);
	}
    
	
	 @GetMapping("/getbyid/{id}")
	 public ResponseEntity<List<LoadFile>>getById(@PathVariable int id) {
		 List<LoadFile> alist =fileService.fetchById(id);
		 
		 return ResponseEntity.ok(alist);

	 	 
	 }
	 
	 @DeleteMapping("/deleteAll")
	 public ResponseEntity<String> deleteAll()
	 {
		 fileService.removeAll();
		 
		 return ResponseEntity.ok("Allfiles deletedsuccessfully");
	 }
	 
    
    


}