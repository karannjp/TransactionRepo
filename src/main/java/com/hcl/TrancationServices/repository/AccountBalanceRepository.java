package com.hcl.TrancationServices.repository;

import com.hcl.TrancationServices.model.AccountBalanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalanceInfo,Integer> {

    Optional<AccountBalanceInfo> findById(Integer id);

}

