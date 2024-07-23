package com.hcl.TrancationServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAmountBlockedDetailsRepository extends JpaRepository<com.hcl.TrancationServices.model.AccountAmountBlockedDetails,Integer> {
}
