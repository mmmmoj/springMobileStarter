package tk.mojahed.spring.mobile.starter.authentication;

import tk.mojahed.spring.mobile.starter.account.DomainBase;

public class AuthenticationRequest extends DomainBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1812501339710638423L;
	private String username;
	private String password;

	public AuthenticationRequest() {
		super();
	}

	public AuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
