package io.ashkan.izadpanah.springboot.courseapi.topic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/* curl command to trigger these resources
 
 * curl -X POST -H 'Content-Type: application/json' http://localhost:8080/topics -d @data.json
 * 
 *data.json
 {
   "id":"springMongo",
   "name":"springBoot with MongoDB",
   "description":"Spring Data support for NoSql"
 }
 
 curl -X DELETE -H 'Content-type : application/json' http://localhost:8080/topics/springMongo
 
 curl -X PUT -d @data.json -H 'Content-Type : application/json' http://localhost:8080/topics/javaCore01
 *data.json
 {
   "id":"javaCore01",
   "name":"Core Java",
   "description":"Java 8 lambdas executors streams"
 }
 * */


/* REST endpoint for JSON and xml 
 * 	using Jackson(ObjectMapper) and JacksonXml(XmlMapper)
 * 
 * */

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/topics")
	List<Topic> getAllTopics(){
		return StreamSupport
			.stream(topicService.getAll().spliterator(), false)
			.collect(Collectors.toList());
		
	}
	
	@RequestMapping("/topics/{id}")
	Topic getTopic(@PathVariable String id){
		return topicService.get(id).get();
	}
	
	//@PostMapping("/topics")
	@RequestMapping(method= {RequestMethod.POST}, path= "/topics")
	void createTopic(@RequestBody Topic topic) {
		topicService.add(topic);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value= "/topics/{id}")
	void updateTopic(@PathVariable String id, @RequestBody Topic topic){
		topicService.update(id, topic);
		
	}
	
	@DeleteMapping("/topics/{id}")
	void deleteTopic(@PathVariable String id) {
		topicService.delete(id);

	}
}
