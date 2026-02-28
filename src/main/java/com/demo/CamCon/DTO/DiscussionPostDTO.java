package com.demo.CamCon.DTO;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.demo.CamCon.Beans.DiscussionTopic;
import com.demo.CamCon.Beans.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiscussionPostDTO {
	
	    @NotBlank
	    private int postId;

	    @NotBlank
	    private String postContent;

	    @NotBlank
	    @NotNull
	    @JsonBackReference
	    @JsonIgnore
	    private DiscussionTopic discussionTopic;
	   
	    @NotBlank
	    private String author;
	   
	    @NotBlank
	    private LocalDateTime date;
	    
	    @NotBlank
	    @NotNull
	    @JsonIgnore
	    private Student student;
	    
	    
	    private int topicId;
	    
	    private int id;

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

		public int getTopicId() {
			return topicId;
		}

		public void setTopicId(int topicId) {
			this.topicId = topicId;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	    
	    

}
