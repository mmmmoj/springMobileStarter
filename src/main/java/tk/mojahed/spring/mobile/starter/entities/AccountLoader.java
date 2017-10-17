package tk.mojahed.spring.mobile.starter.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tk.mojahed.spring.mobile.starter.entities.Account;
import tk.mojahed.spring.mobile.starter.repositories.AccountRepository;

@Component
public class AccountLoader implements CommandLineRunner {
	private final AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public AccountLoader(AccountRepository accountRepository) {

		this.accountRepository = accountRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		this.accountRepository.save(new Account("moj", passwordEncoder.encode("moj"),"ADMIN"));

//		SecurityContextHolder.getContext().setAuthentication(
//			new UsernamePasswordAuthenticationToken("moj", "moj",
//				AuthorityUtils.createAuthorityList("ADMIN")));
//
//		SecurityContextHolder.clearContext();
	}
}
