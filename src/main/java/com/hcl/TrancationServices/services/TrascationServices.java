package com.hcl.TrancationServices.services;

import com.hcl.TrancationServices.model.AccountBalance;
import com.hcl.TrancationServices.repository.AccountBalanceRepository;
import com.hcl.TrancationServices.repository.AccountDetailsRepository;
import com.hcl.TrancationServices.repository.TranscationRepository;
import jakarta.transaction.Transactional;
import lombok.Synchronized;
import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TrascationServices {


    private TranscationRepository transcationRepository;

    private AccountBalanceRepository accountBalanceRepository;

    private AccountDetailsRepository accountDetailsRepository;

    @Autowired
public  TrascationServices(TranscationRepository transcationRepository,AccountBalanceRepository accountBalanceRepository,AccountDetailsRepository accountDetailsRepository){
    this.accountBalanceRepository=accountBalanceRepository;
    this.accountDetailsRepository=accountDetailsRepository;
    this.transcationRepository=transcationRepository;
}

public long getBalance(String account_no){
        return  accountBalanceRepository.findByAccountNo(Integer.valueOf(account_no))
                .map()
                .orElse(BigDecimal.ZERO);
}
@Transactional
@Synchronized
public  void initiateTrascation(String debitAccountNo,String creditAccountNo,Double amount){
        AccountBalance debitAccount=accountBalanceRepository.findByAccountNo(Integer.valueOf(debitAccountNo)).orElseThrow(()-> new RuntimeException("debit account not found"+debitAccountNo));
    AccountBalance creditAccount=accountBalanceRepository.findByAccountNo(Integer.valueOf(creditAccountNo)).orElseThrow(()-> new RuntimeException("credit account not found"+creditAccountNo));
if(debitAccountNo.getBalance().copareTo(amount) < 0){
     throw new RuntimeException("Insufficient Funds");
}
    debitAccount.setBalance(debitAccount.getBalance().substract(amount));
    creditAccount.setBalance(creditAccount.getBalance().add(amount));

}









}
