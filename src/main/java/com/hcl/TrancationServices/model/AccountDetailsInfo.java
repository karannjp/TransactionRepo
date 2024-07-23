package com.hcl.TrancationServices.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="accountDetailsInfo")
@Entity
public class AccountDetailsInfo {

    @Id
    private String accountId;
    private String accountNumber;
    private String bankName;
    private String account_iban;
    private String currency;
    private Date accountOpeningDate;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserDetailsInfo userDetails;
    @OneToMany
    private List<AccountAmountBlockedDetails> accountAmountBlockedDetails;



}
