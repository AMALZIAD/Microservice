package sid.org.microservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.enums.AccountType;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    List<BankAccount> findByType(AccountType type);
}
