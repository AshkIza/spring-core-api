package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ashkan.izadpanah.springboot.courseapi.topic.Topic;
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
	
	Optional<Course> get(Long id){
		return courseRepository.findById(id);
	}
	
	void add(Course course) {	
		if(course.getTopic() != null && course.getTopic().getId() == null) {
			//should save the topic first 
			Topic topic = topicRepository.save(course.getTopic());
			course.setTopic(topic);
		}
		courseRepository.save(course);
	}

	public List<Course> getAllCoursesforTopic(Long topicId) {
		return courseRepository.findByTopicId(topicId);
		
	}
	
	public void update(Course course) {
		topicRepository.save(course.getTopic());//updating the Topic first
		courseRepository.save(course);
	}

	public void delete(Long id) {
		courseRepository.deleteById(id);
		
	}

}
