package tk.mojahed.spring.mobile.starter.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tk.mojahed.spring.mobile.starter.entities.Account;

@RepositoryRestResource(exported = false)
public interface AccountRepository extends CrudRepository<Account, UUID> {

	Account findByEmail(String email);

}
