package com.hcl.TrancationServices.repository;

import com.hcl.TrancationServices.model.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance,Integer> {

    Optional<AccountBalance> findByAccountNo(Integer integer);

}

