package com.hcl.TrancationServices.repository;

import com.hcl.TrancationServices.model.Account_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<Account_details,Integer> {
}
