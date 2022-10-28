package sid.org.microservice.entities;

import org.springframework.data.rest.core.config.Projection;
import sid.org.microservice.enums.AccountType;

@Projection(types = BankAccount.class, name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public double getBalance();
}
