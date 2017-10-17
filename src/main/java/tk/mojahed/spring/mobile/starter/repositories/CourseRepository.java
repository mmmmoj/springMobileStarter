package tk.mojahed.spring.mobile.starter.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import tk.mojahed.spring.mobile.starter.entities.Course;

public interface CourseRepository extends CrudRepository<Course,UUID> {
	public List<Course> findByTopicId(String topicId);
}
