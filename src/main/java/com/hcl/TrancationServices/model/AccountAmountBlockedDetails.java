package com.hcl.TrancationServices.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="accountAmountBlockedDetails")
@Entity
public class AccountAmountBlockedDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double blockedAmount;
    private String blockedReferanceNo;
    private Boolean blockedStatus;
    @ManyToOne
    @JoinColumn(name="account_amount_blocked_details", nullable=false)
    private AccountDetailsInfo accountDetailsInfo;
}
