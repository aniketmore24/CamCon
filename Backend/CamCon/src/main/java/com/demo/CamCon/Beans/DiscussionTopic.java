package com.demo.CamCon.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DiscussionTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;

    @Column( nullable = false, length = 50)
    private String topic;
    
    @Column(length = 500, nullable = false)
    private String description ;

	/*
	 * @OneToMany private Set<DiscussionPost> discussionPost;
	 */

    public DiscussionTopic(String topic, String description) {
       // this.topicId=topicId;
        this.topic = topic;
        this.description = description;
    }

    public DiscussionTopic() {
		super();
	}

    
    
	@Override
    public String toString() {
        return "topicIdDiscussionTopic{" +
                "topicId=" + topicId +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
