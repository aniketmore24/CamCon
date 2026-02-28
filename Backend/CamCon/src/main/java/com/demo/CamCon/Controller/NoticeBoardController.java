package com.demo.CamCon.Controller;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/noticeBoard")
public class NoticeBoardController {

    @Autowired
    NoticeBoardService noticeBoardService;

    @PostMapping("/addNotice")
    public ResponseEntity<?> addNotice(@RequestBody NoticeBoard noticeBoard) throws IOException {

        

        return ResponseEntity.ok(noticeBoardService.saveNotice(noticeBoard)) ;
    }

    /*
    *     @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getBytes());
            fileRepository.save(fileModel);
            return new ResponseEntity<>("File uploaded successfully!", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    * */

    @GetMapping("/getAll")
    public List<NoticeBoard> getAllNotices(){
        return noticeBoardService.getAllNotices();
    }
    
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
    	
    	noticeBoardService.deleteById(id);
    	
    	return  ResponseEntity.ok(HttpStatus.OK);
    	
    }
    
    

}
