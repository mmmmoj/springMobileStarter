package tk.mojahed.spring.mobile.starter.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import tk.mojahed.spring.mobile.starter.entities.Topic;
import tk.mojahed.spring.mobile.starter.repositories.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("1","name1","desc1"),
//			new Topic("2","name2","desc2"),
//			new Topic("3","name3","desc3")
//			));
	
	public List<Topic> getAllTopics() {
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(UUID id) {
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get(); 
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(UUID id,Topic topic) {
//		for(int i=0;i<topics.size();i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		topicRepository.save(topic);
	}
	
	public void removeTopic(UUID id) {
		//topics.removeIf(t->t.getId().equals(id));
		topicRepository.delete(id);
	}
}
