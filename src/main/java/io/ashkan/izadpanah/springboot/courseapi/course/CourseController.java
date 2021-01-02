package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/* REST endpoint for courses , accepts JUST JSON 
 *  using Jackson (ObjectMapper) 
 *  
 *   @RestController --> @Controller + @ResponseBody 
 *  
 *  curl -H 'accept : application/json'       --> produces = MediaType.APPLICATION_JSON_VALUE, 
 *  curl -h 'Content-Type : application/json' --> consumes = MediaType.APPLICATION_JSON_VALUE
 * 
 * */
@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(path = "/courses")
	@ResponseBody
	List<Course> getAllCourses(){
		return courseService.getAll();
	}
	
	@GetMapping(path = "/courses/{id}")
	@ResponseBody
	Course getCourse(@PathVariable String id){
		return courseService.get(id).get();
	}
	
	@PostMapping(value = "/courses")
	@ResponseBody
	void createCourse(@RequestBody Course course) {
		courseService.add(course);
	}
	
	@PutMapping(value = "/courses/{id}")
	@ResponseBody
	void updateCourse(@PathVariable String id, @RequestBody Course course) {
		course.setId(id);
		courseService.update(course);
	}
	
	

}
