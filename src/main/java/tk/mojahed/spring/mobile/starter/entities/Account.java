package tk.mojahed.spring.mobile.starter.entities;

import tk.mojahed.spring.mobile.starter.account.DomainBase;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Account extends DomainBase {
	private static final long serialVersionUID = 2353528370345499815L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String email;
	private String password;
	private Date lastPasswordReset;
	private Date createdAt;
	private Date modifiedAt;
	@Column(name = "authorities")
	private String authorities;

	public Account() {
		super();
	}

	public Account(String email, String password, String authorities) {
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public String getUsername() {
		return email;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedAt = new Date();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String email) {
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.setLastPasswordReset(new Date());
	}

	public Date getLastPasswordReset() {
		return lastPasswordReset;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
