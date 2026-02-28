package com.demo.CamCon.Service;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@Service
public class DiscussionTopicServiceImpl implements DiscussionTopicService {
    Scanner sc= new Scanner(System.in);
    @Autowired
    private DiscussionTopicRepository  discussionTopicRepository;

    @Override
    public DiscussionTopic createNewTopic(DiscussionTopic discussionTopic) {
        return discussionTopicRepository.save(discussionTopic);
    }

    @Override
    public List<DiscussionTopic> getAllTopics() {
       
    	List<DiscussionTopic> dlist = discussionTopicRepository.findAll();
    	System.out.println(dlist);
    	return dlist;
    }

    //Need to look at Return type
    @Override
    public DiscussionTopic findTopicById(int topicId) {
        return discussionTopicRepository.findById(topicId).get();
    }

    @Override
    public DiscussionTopic modifyTopic(DiscussionTopic discussionTopic) {
        System.out.println("Enter modified topic name");
        String temp = sc.next();
       // discussionTopic.setTopic(temp);
        return null;
    }

    // Only admin can delete Topic
    @Override
    public void deleteTopicById(int id) {
         discussionTopicRepository.deleteById(id);
    }
}
