package com.hcl.TrancationServices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="transactionDetails")
@Entity
public class TransactionDetails {
    @Id
    private String transactionId;
    private String userid;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private Timestamp transactionTime;

}