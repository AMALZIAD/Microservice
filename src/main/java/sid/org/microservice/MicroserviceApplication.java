
package sid.org.microservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.entities.Customer;
import sid.org.microservice.enums.AccountType;
import sid.org.microservice.repositories.BankAccountRepository;
import sid.org.microservice.repositories.CustomerRepository;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceApplication.class, args);
        System.out.println("hello");
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Mohamed","Yassine","Hanae","Imane").forEach(c->{
                Customer customer= Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(c->{
                for (int i=0; i<10; i++){
                    BankAccount bankAccount= BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
                            .balance(10000+Math.random()*90000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(c)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };
    }

}
