package com.demo.CamCon.Controller;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Discuss")
public class DiscussionTopicController {
    Scanner sc = new Scanner(System.in);
    @Autowired
    private DiscussionTopicService discussionTopicService;
   
    @PostMapping("/CreateNewTopic")
    public DiscussionTopic createNewTopic(@RequestBody DiscussionTopic discussionTopic){
        discussionTopicService.createNewTopic(discussionTopic);
        return  discussionTopicService.createNewTopic(discussionTopic);
    }
  
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTopics(){
    	List<DiscussionTopic> dlist = discussionTopicService.getAllTopics();
    	System.out.println(dlist);
       // return ResponseEntity.ok(dlist.get(0));
    	//return new ResponseEntity<>(dlist, HttpStatus.OK);
    	return ResponseEntity.status(HttpStatus.OK).body(dlist);
    }


    @GetMapping("/findTopicById/{id}")
    public DiscussionTopic findTopic(@PathVariable int id){
    	System.out.println(id);
        return discussionTopicService.findTopicById(id);
    }


    // If User want to modify the Topic
//    @PostMapping("/modifyTopic")
//    public DiscussionTopic modifyTopic(@RequestBody int topicId){
//        Optional<DiscussionTopic> discussionTopic = discussionTopicService.findTopicById(topicId);
//        boolean status= discussionTopic.isPresent();
//        if(status){
//            //discussionTopicService.modifyTopic(discussionTopic);
//            // Needs To Fixxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx this
//        }
//        return null;
//    }

    // Only admin should have authority to delete the topic
    @PostMapping("/deleteTopic")
    public String deleteTopic(@RequestBody int topicId){
        discussionTopicService.deleteTopicById(topicId);
        return "Topic deleted Successfully";
    }
}
