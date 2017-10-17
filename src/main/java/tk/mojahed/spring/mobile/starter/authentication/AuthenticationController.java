package tk.mojahed.spring.mobile.starter.authentication;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tk.mojahed.spring.mobile.starter.entities.Account;
import tk.mojahed.spring.mobile.starter.account.AccountModel;
import tk.mojahed.spring.mobile.starter.repositories.AccountRepository;
import tk.mojahed.spring.mobile.starter.account.UserDetailsServiceImpl;

import java.util.*;

@RestController
@RequestMapping("${moj.route.authentication}")
public class AuthenticationController {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Value("${moj.token.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest,
			Device device) throws AuthenticationException {

		// Perform the authentication
		Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-authentication so we can generate token
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String token = this.tokenUtils.generateToken(userDetails, device);

		// Return the token
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}

	@RequestMapping(value = "${moj.route.authentication.refresh}", method = RequestMethod.GET)
	public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
		String token = request.getHeader(this.tokenHeader);
		String username = this.tokenUtils.getUsernameFromToken(token);
		AccountModel user = (AccountModel) this.userDetailsService.loadUserByUsername(username);
		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
			String refreshedToken = this.tokenUtils.refreshToken(token);
			return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Account> getAll() {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Account signup(@RequestBody Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return accountRepository.save(account);
	}

}
