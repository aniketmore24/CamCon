package com.demo.CamCon.Beans;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.demo.CamCon.Beans.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiscussionPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String postContent;

    @ManyToOne
    @JoinColumn(name = "topicId")
    private DiscussionTopic discussionTopic;
   
    private String author;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "studId")
    private Student student;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public DiscussionTopic getDiscussionTopic() {
		return discussionTopic;
	}

	public void setDiscussionTopic(DiscussionTopic discussionTopic) {
		this.discussionTopic = discussionTopic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
    
}
