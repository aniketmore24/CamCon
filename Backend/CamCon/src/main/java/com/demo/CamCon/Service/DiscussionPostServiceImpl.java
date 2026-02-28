package com.demo.CamCon.Service;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.DTO.DiscussionPostDTO;
import com.demo.CamCon.Dao.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionPostServiceImpl implements DiscussionPostService {
    @Autowired
    private DiscussionPostRepository discussionPostRepository;
    
    @Autowired
    private DiscussionTopicRepository topicrepo;
    
    @Autowired
    private StudentsDaoIF studentrepo;
    
   
    @Autowired
    ModelMapper mapper;

    
//    @Override
//    public DiscussionPostDTO addPost(DiscussionPostDTO discussionPost) {
//    	
//    	discussionPost.setDiscussionTopic(topicrepo.findById(discussionPost.getTopicId()));
//    	discussionPost.setStudent(null);
//    	DiscussionPost dpost = mapper.map(discussionPost, DiscussionPost.class);
//    	
//    	
//    	  discussionPostRepository.save(dpost);
//    	 
//    	 
//    	  DiscussionPostDTO postDTO = mapper.map(dpost, DiscussionPostDTO.class);
//    	  
//    	  return postDTO;
//    	 
//    	 
//    	 
//    }
    

    @Override
    public DiscussionPost addPost(DiscussionPost discussionPost) {
    	
    	//scussionPost.setStudent(studentrepo.findById(discussionPost.getStudent().getId()));
    //iscussionPost.setDiscussionTopic(topicrepo.findById(discussionPost.getDiscussionTopic().getTopicId()));
    	
    	return discussionPostRepository.save(discussionPost);
    	
    }

    @Override
    public List<DiscussionPost> getAllPosts() {
        return discussionPostRepository.findAll();
    }

    @Override
    public Optional<DiscussionPost> findPost(int postId) {
        return discussionPostRepository.findById(postId);
    }

    @Override
    public void deletePost(int postId) {
        discussionPostRepository.deleteById(postId);
    }

    // Not Used
    @Override
    public List<DiscussionPost> getSimilarPosts(String keyword) {
        String keyword2 ="%"+keyword+"%";
        return discussionPostRepository.findByPostContentLike(keyword2);
    }

    @Override
	public List<DiscussionPost> getByTopicId(int id) {
		// TODO Auto-generated method stub
		return discussionPostRepository.findBydiscussionTopicTopicId(id);
	}
}
