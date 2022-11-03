package sid.org.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sid.org.microservice.dto.BankAccountRequestDTO;
import sid.org.microservice.dto.BankAccountResponseDTO;
import sid.org.microservice.entities.BankAccount;
import sid.org.microservice.mappers.AccountMapper;
import sid.org.microservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {

        //mapping
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO= accountMapper.fromBankAccount(savedBankAccount);
    return bankAccountResponseDTO ;
    }
    @Override
    public BankAccountResponseDTO updateAccount(BankAccountRequestDTO bankAccountDTO,String id) {

        //mapping
        BankAccount bankAccount=BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO= accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO ;
    }
}
