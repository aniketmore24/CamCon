package com.demo.CamCon.Service;

import com.demo.CamCon.Beans.*;

import java.util.List;
import java.util.Optional;

public interface DiscussionTopicService {

    public DiscussionTopic createNewTopic(DiscussionTopic discussionTopic);

    public List<DiscussionTopic> getAllTopics();

    public DiscussionTopic findTopicById(int topicId);

    public DiscussionTopic modifyTopic(DiscussionTopic discussionTopic);

    public void deleteTopicById(int id);
}
