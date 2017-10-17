package tk.mojahed.spring.mobile.starter.entities;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	private String description;
	
	public Topic() {
		
	}
	
	public Topic(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Topic(UUID id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Transient
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
