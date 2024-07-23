package com.hcl.TrancationServices.services;

import com.hcl.TrancationServices.model.AccountAmountBlockedDetails;
import com.hcl.TrancationServices.model.AccountBalanceInfo;
import com.hcl.TrancationServices.model.UserDetailsInfo;
import com.hcl.TrancationServices.repository.AccountAmountBlockedDetailsRepository;
import com.hcl.TrancationServices.repository.AccountBalanceRepository;
import com.hcl.TrancationServices.repository.AccountDetailsRepository;
import com.hcl.TrancationServices.repository.TranscationRepository;
import jakarta.transaction.Transactional;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TrascationServices {

    @Autowired
    private TranscationRepository transcationRepository;
    @Autowired
    private AccountBalanceRepository accountBalanceRepository;
    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Autowired
    private com.hcl.TrancationServices.repository.AccountAmountBlockedDetailsRepository AccountAmountBlockedDetailsRepository;


    @Transactional
    public   void prechecDetails(int userid ,int debitAccountNo,int creditAccountNo,Double amount){
        AccountBalanceInfo debitAccount=accountBalanceRepository.findById(debitAccountNo).orElseThrow(()-> new RuntimeException("debit account not found"+debitAccountNo));
        AccountBalanceInfo creditAccount=accountBalanceRepository.findById(creditAccountNo).orElseThrow(()-> new RuntimeException("credit account not found"+creditAccountNo));

        if(debitAccount.getBalance() < 0){
            throw new RuntimeException("Insufficient Funds");
        }
        String random_id= UUID.randomUUID().toString();
        AccountAmountBlockedDetails accountAmountBlockedDetails1=new AccountAmountBlockedDetails();
        accountAmountBlockedDetails1.setId(userid);
        accountAmountBlockedDetails1.setBlockedAmount(amount);
        accountAmountBlockedDetails1.setBlockedReferanceNo(random_id);
        accountAmountBlockedDetails1.setBlockedStatus(true);
        AccountAmountBlockedDetailsRepository.save(accountAmountBlockedDetails1);

    }


@Transactional
@Synchronized
public  void initiateTrascation(int debitAccountNo,int creditAccountNo,Double amount){
    AccountBalanceInfo debitAccount=accountBalanceRepository.findById(debitAccountNo).orElseThrow(()-> new RuntimeException("debit account not found"+debitAccountNo));
    AccountBalanceInfo creditAccount=accountBalanceRepository.findById(creditAccountNo).orElseThrow(()-> new RuntimeException("credit account not found"+creditAccountNo));
    if(debitAccount.getBalance().compareTo(amount) < 0){
        throw new RuntimeException("Insufficient Funds");
    }
    debitAccount.setBalance(debitAccount.getBalance() - amount);
    creditAccount.setBalance(creditAccount.getBalance()+amount);
    AccountAmountBlockedDetails accountAmountBlockedDetails1=new AccountAmountBlockedDetails();
    accountAmountBlockedDetails1.setBlockedStatus(false);
    accountBalanceRepository.save(creditAccount);


}









}
