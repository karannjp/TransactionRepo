package com.hcl.TrancationServices.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="accountBalanceInfo")
@Entity
public class AccountBalanceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountDetails")
    private AccountDetailsInfo accountId;
    private Double balance;



}