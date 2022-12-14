package sid.org.microservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sid.org.microservice.enums.AccountType;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
