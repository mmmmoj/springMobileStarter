package tk.mojahed.spring.mobile.starter.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import tk.mojahed.spring.mobile.starter.entities.Course;
import tk.mojahed.spring.mobile.starter.services.CourseService;
import tk.mojahed.spring.mobile.starter.entities.Topic;

@RestController
@RequestMapping("${moj.route.protected}")
@PreAuthorize("@securityService.hasProtectedAccess()")
public class CourseCTRL {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topic/{id}/courses")
	public List<Course> getAll(@PathVariable("id") String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topic/{topicId}/courses/{id}")
	public Course getById(@PathVariable("id") UUID id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value="/topic/{topicId}/courses",method=RequestMethod.POST)
	public void add(@RequestBody Course course,@PathVariable("topicId") UUID topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topic/{topicId}/courses/{id}",method=RequestMethod.PUT)
	public void update(@PathVariable("id") String id,@RequestBody Course course,@PathVariable("topicId") UUID topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topic/{topicId}/courses/{id}",method=RequestMethod.DELETE)
	public void remove(@PathVariable("id") UUID id) {
		courseService.removeCourse(id);
	}
}
