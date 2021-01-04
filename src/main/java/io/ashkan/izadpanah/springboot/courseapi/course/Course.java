package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.ashkan.izadpanah.springboot.courseapi.book.Book;
import io.ashkan.izadpanah.springboot.courseapi.topic.Topic;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String title;
	String description;
	@ManyToOne
	Topic topic;
	
	/*@ManyToMany
	@JoinTable(name = "course_book",
		joinColumns = { @JoinColumn(name = "fk_course") },
		inverseJoinColumns = { @JoinColumn(name = "fk_book") })*/
	@OneToMany
	List<Book> recommendedBooks = new ArrayList<>();
	
	public Course() {
	}

	public Course(Long id, String title, String description, Topic topic, List<Book> recommendedBooks) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.topic = topic;
		this.recommendedBooks = recommendedBooks;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Book> getRecommendedBooks() {
		return recommendedBooks;
	}

	public void setRecommendedBooks(List<Book> recommendedBooks) {
		this.recommendedBooks = recommendedBooks;
	}
	
}
