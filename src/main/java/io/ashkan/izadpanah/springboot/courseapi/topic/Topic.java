package io.ashkan.izadpanah.springboot.courseapi.topic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
	 String name;
	 String details;//search keys , comma separated
	 
	public Topic() {
		super();
	}

	public Topic(Long id, String name, String details) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
