package tk.mojahed.spring.mobile.starter.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import tk.mojahed.spring.mobile.starter.entities.Course;
import tk.mojahed.spring.mobile.starter.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(UUID id) {
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void removeCourse(UUID id) {
		courseRepository.delete(id);
	}
}
