package sid.org.microservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sid.org.microservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
