package com.hcl.TrancationServices.repository;

import com.hcl.TrancationServices.model.AccountBalanceInfo;
import com.hcl.TrancationServices.model.AccountDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetailsInfo,String> {
}
