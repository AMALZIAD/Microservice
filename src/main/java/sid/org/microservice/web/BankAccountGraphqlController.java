package sid.org.microservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sid.org.microservice.dto.BankAccountRequestDTO;
import sid.org.microservice.dto.BankAccountResponseDTO;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.entities.Customer;
import sid.org.microservice.repositories.BankAccountRepository;
import sid.org.microservice.repositories.CustomerRepository;
import sid.org.microservice.service.AccountService;

import java.util.Date;
import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount>accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account is not found ",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount     ){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument BankAccountRequestDTO bankAccount,@Argument String id){
        return accountService.updateAccount(bankAccount,id);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
    }
    // CUSTOMER
    @QueryMapping
    public List<Customer>customers(){
        return customerRepository.findAll();
    }
}
/*
record BankAccountDTO (Double balance,String type,String currency){

}*/