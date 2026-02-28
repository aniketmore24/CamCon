package com.demo.CamCon.Controller;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.DTO.DiscussionPostDTO;
import com.demo.CamCon.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/Post")
public class DiscussionPostController {
    @Autowired
    private DiscussionPostService discussionPostService;

    @Autowired
    private DiscussionTopicService discussionTopicService;

    
//    @PostMapping("/addPost")
//    public ResponseEntity<?> addPost(@RequestBody  DiscussionPostDTO discussionPost){
//    	//System.out.println(discussionPost);
//       
//    	return ResponseEntity.status(HttpStatus.CREATED).body(discussionPostService.addPost(discussionPost));
//    }


    @PostMapping("/addPost")
    public ResponseEntity<?> addPost(@RequestBody  DiscussionPost discussionPost){    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(discussionPostService.addPost(discussionPost));
    }
    
   
    
    @GetMapping("/getAll")
    public List<DiscussionPost> getAll(){
        return discussionPostService.getAllPosts();
    }
    
    
    @GetMapping("/getposts/{id}")
    public ResponseEntity<List<DiscussionPost>> getPosts(@PathVariable int id){
    	
    	return ResponseEntity.ok(discussionPostService.getByTopicId(id));  	
    }
    

    @PostMapping("/findPost")
    public Optional<DiscussionPost> findPost(@RequestBody int postId){
        return discussionPostService.findPost(postId);
    }

    
    // Student who posted post/comment; only that person and admin should have authority to delete the post
    @PostMapping("/deletePost")
    public String deletePost(@RequestBody int postId){
        discussionPostService.deletePost(postId);
        return "Post deleted successfully";
    }


    @PostMapping("/getSimilarPosts")
    public List<DiscussionPost> getSimilarPosts(@RequestBody String keyword){
        return discussionPostService.getSimilarPosts(keyword);
    }
}
