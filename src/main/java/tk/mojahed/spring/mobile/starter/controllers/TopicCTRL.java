package tk.mojahed.spring.mobile.starter.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tk.mojahed.spring.mobile.starter.entities.Topic;
import tk.mojahed.spring.mobile.starter.services.TopicService;

@RestController
@RequestMapping("${moj.route.protected}")
@PreAuthorize("@securityService.hasProtectedAccess()")
public class TopicCTRL {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable("id") UUID id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/topic",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topic/{id}",method=RequestMethod.PUT)
	public void updateTopic(@PathVariable("id") UUID id,@RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(value="/topic/{id}",method=RequestMethod.DELETE)
	public void removeTopic(@PathVariable("id") UUID id) {
		topicService.removeTopic(id);
	}
}
