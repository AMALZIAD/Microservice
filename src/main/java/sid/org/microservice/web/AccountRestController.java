package sid.org.microservice.web;

import org.springframework.web.bind.annotation.*;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.repositories.BankAccountRepository;

import javax.management.RuntimeErrorException;
import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List <BankAccount>bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getbankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account is not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
       BankAccount account =bankAccountRepository.findById(id).orElseThrow();
       if(bankAccount.getBalance()!=0) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(bankAccount);
    }


    @DeleteMapping("/bankAccounts/{id}5")
    public void save(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }
}
