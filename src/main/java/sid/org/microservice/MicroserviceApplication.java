
package sid.org.microservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.enums.AccountType;
import sid.org.microservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceApplication.class, args);
        System.out.println("hello");
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            for (int i=0; i<10; i++){
                BankAccount bankAccount= BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }

}
