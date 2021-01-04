package io.ashkan.izadpanah.springboot.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {	
	@Autowired
	TopicRepository topicRepository;
	/*List<Topic> inmemoryDB = new ArrayList(Arrays.asList(new Topic("javaCore", "Core Java", "Java 8 introduction"),
			   new Topic("springFramework", "Spring framework", "Spring Core/MVC/Rest/Data/Batch/Security"),
			   new Topic("k8s", "kubernetes", "dockerizeing applications and kubernetes deployment")));*/
	
	Iterable<Topic> getAll(){
		return topicRepository.findAll();
	}
	
	public Optional<Topic> get(Long id){
		return topicRepository.findById(id);
	}
	
	void add(Topic topic) {
		topicRepository.save(topic);
	}

	public void update(Long id, Topic topic) {
		topic.setId(id);
		topicRepository.save(topic);
	}

	public void delete(Long id) {
		topicRepository.deleteById(id);
	}

}
