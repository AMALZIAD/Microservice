package sid.org.microservice.service;

import sid.org.microservice.dto.BankAccountRequestDTO;
import sid.org.microservice.dto.BankAccountResponseDTO;


public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
