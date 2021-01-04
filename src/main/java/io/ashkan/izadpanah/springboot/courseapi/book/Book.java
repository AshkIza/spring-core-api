package io.ashkan.izadpanah.springboot.courseapi.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import io.ashkan.izadpanah.springboot.courseapi.course.Course;
import io.ashkan.izadpanah.springboot.courseapi.topic.Topic;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String title;
	String description;
	String authur;
	boolean onlineResource;
	String isb;
	String urlLink;
	@ManyToOne
	Topic topic;
	/*@ManyToMany(mappedBy="recommendedBooks")
	List<Course> attachedCourses = new ArrayList<>();*/
	
	public Book() {
		
	}
	
	public Book(Long id, String title, String description, String authur, boolean onlineResource, String isb,
			String urlLink, Topic topic) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.authur = authur;
		this.onlineResource = onlineResource;
		this.isb = isb;
		this.urlLink = urlLink;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthur() {
		return authur;
	}

	public void setAuthur(String authur) {
		this.authur = authur;
	}

	public boolean isOnlineResource() {
		return onlineResource;
	}

	public void setOnlineResource(boolean onlineResource) {
		this.onlineResource = onlineResource;
	}

	public String getIsb() {
		return isb;
	}

	public void setIsb(String isb) {
		this.isb = isb;
	}

	public String getUrlLink() {
		return urlLink;
	}

	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
