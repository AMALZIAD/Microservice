package sid.org.microservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sid.org.microservice.dto.BankAccountRequestDTO;
import sid.org.microservice.dto.BankAccountResponseDTO;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.mappers.AccountMapper;
import sid.org.microservice.repositories.BankAccountRepository;
import sid.org.microservice.service.AccountService;


import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

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
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
       BankAccount account =bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=0) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }


    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }
}
