package tk.mojahed.spring.mobile.starter.account;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import tk.mojahed.spring.mobile.starter.entities.Account;

public class AccountFactory {
	
	public static AccountModel create(Account account) {
		Collection<? extends GrantedAuthority> authorities;
	    try {
	      authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(account.getAuthorities());
	    } catch (Exception e) {
	      authorities = null;
	    }
	    return new AccountModel(
	      account.getId(),
	      account.getEmail(),
	      account.getPassword(),
	      account.getLastPasswordReset(),
	      account.getCreatedAt(),
	      account.getModifiedAt(),
	      authorities
	    );
	}

}
