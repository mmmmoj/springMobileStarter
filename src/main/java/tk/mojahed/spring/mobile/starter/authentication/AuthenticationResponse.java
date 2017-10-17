package tk.mojahed.spring.mobile.starter.authentication;

import tk.mojahed.spring.mobile.starter.account.DomainBase;

public class AuthenticationResponse extends DomainBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7933696684274186781L;
	private String token;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token) {
		this.setToken(token);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}