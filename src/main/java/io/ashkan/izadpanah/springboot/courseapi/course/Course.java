package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.ashkan.izadpanah.springboot.courseapi.topic.Topic;

@Entity
public class Course {
	@Id
	String id;
	String title;
	@ManyToOne
	Topic topic;
	
	public Course() {
	}
	public Course(String id, String title, Topic topicId) {
		super();
		this.id = id;
		this.title = title;
		this.topic = topic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
