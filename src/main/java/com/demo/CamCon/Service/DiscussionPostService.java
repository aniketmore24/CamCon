package com.demo.CamCon.Service;

import aj.org.objectweb.asm.Label;
import com.demo.CamCon.Beans.*;
import com.demo.CamCon.DTO.DiscussionPostDTO;

import java.util.List;
import java.util.Optional;

public interface DiscussionPostService {

    public DiscussionPost addPost(DiscussionPost discussionPost);

    public List<DiscussionPost> getAllPosts();

    public Optional<DiscussionPost> findPost(int postId);

    public void deletePost(int postId);

    public List<DiscussionPost> getSimilarPosts(String keyword);

	public List<DiscussionPost> getByTopicId(int id);
}
