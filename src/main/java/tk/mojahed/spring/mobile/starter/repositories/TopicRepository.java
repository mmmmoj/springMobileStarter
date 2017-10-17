package tk.mojahed.spring.mobile.starter.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import tk.mojahed.spring.mobile.starter.entities.Topic;

public interface TopicRepository extends CrudRepository<Topic,UUID> {
	
}
