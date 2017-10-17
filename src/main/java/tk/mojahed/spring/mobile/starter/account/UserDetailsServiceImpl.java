package tk.mojahed.spring.mobile.starter.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mojahed.spring.mobile.starter.entities.Account;
import tk.mojahed.spring.mobile.starter.repositories.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = this.accountRepository.findByEmail(email);
		if (account == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		} else {
			return AccountFactory.create(account);
		}
	}

}
