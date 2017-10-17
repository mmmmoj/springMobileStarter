package tk.mojahed.spring.mobile.starter.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tk.mojahed.spring.mobile.starter.repositories.TopicRepository;

@Component
public class DatabaseLoader implements CommandLineRunner{
	private final TopicRepository repository;
	
	@Autowired
	public DatabaseLoader(TopicRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Topic("Math", "Demo math"));
		this.repository.save(new Topic("Sci", "Demo science"));
		this.repository.save(new Topic("Bio", "Demo bilogy"));
	}
}