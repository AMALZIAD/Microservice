package sid.org.microservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sid.org.microservice.dto.BankAccountResponseDTO;
import sid.org.microservice.entities.BankAccount;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
