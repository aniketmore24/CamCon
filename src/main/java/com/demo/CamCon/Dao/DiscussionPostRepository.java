package com.demo.CamCon.Dao;

import com.demo.CamCon.Beans.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscussionPostRepository extends JpaRepository<DiscussionPost, Integer> {

    List<DiscussionPost> findByPostContentLike(String postContent);
    List<DiscussionPost> findBydiscussionTopicTopicId(int id);
    
//    @Query("SELECT findByTopicId from DiscussionPost where DiscussionPost.discussionTopic.topicId = :id")
//    List<DiscussionPost> findByTopicId(int id);

    
}

