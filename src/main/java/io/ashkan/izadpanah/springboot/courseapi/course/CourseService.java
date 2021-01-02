package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ashkan.izadpanah.springboot.courseapi.topic.TopicRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	TopicRepository topicRepository;

	
	/*List<Course> inmemoryDB = new ArrayList(Arrays.asList(
			new Course("howtodoinjava", "howtodoinjava.com", "javaCore"),
			new Course("futures", "futures and completeable futures", "javaCore"),
			new Course("springbootstarter", "youtube/javabrains/Spring Boot Quick Start","springFramework")));*/
	
	List<Course> getAll(){
		return  courseRepository.findAll();
	}
	
	Optional<Course> get(String id){
		return courseRepository.findById(id);
	}
	
	void add(Course course) {
		if(course.getTopic()!=null) {
			topicRepository.save(course.getTopic());//saving the Topic first
		}
		courseRepository.save(course);
	}

	public List<Course> getAllCoursesforTopic(String topicId) {
		return courseRepository.findByTopicId(topicId);
		
	}
	
	public void update(Course course) {
		topicRepository.save(course.getTopic());//updating the Topic first
		courseRepository.save(course);
	}

}
