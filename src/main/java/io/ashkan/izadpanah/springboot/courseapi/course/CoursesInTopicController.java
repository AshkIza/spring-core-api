package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ashkan.izadpanah.springboot.courseapi.topic.Topic;
import io.ashkan.izadpanah.springboot.courseapi.topic.TopicService;


/* REST endpoint with 
 * 	costume Response -> ResponseEntity<> instead of @ResponseBody
 *   
 * 
 * */

@RestController
@RequestMapping(value ="/coursesInTopic")
public class CoursesInTopicController {
	@Autowired
	CourseService courseService;
	@Autowired
	TopicService topicService;
	
	@RequestMapping(value ="/{topicId}", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Course>> getAllCoursesforTopic(@PathVariable Long topicId){
		Topic topic = topicService.get(topicId).get();
		List<Course>  courses= courseService.getAllCoursesforTopic(topicId);
		return ResponseEntity.ok(courses);
	}
	
	@RequestMapping(value ="/concise/{topicId}", 
			produces = MediaType.TEXT_PLAIN_VALUE,
			consumes = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<String> getConciseCourseInfo(@PathVariable Long topicId){
		Topic topic = topicService.get(topicId).get();
		if(topic == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s is not a valid topicId", topicId));
		}
		List<Course>  courses= courseService.getAllCoursesforTopic(topicId);
		String body = String.format( " %d Course(s) available for '%s' :", courses.size(), topicId) +
				courses.stream().map(course -> course.getTitle())
				.reduce("\n", (a,b) -> a + "\n" + b);
		return ResponseEntity.ok().body(body);
	}

}
