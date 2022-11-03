package sid.org.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sid.org.microservice.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
