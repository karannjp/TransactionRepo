package com.hcl.TrancationServices.repository;

import com.hcl.TrancationServices.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscationRepository  extends JpaRepository<Account,Integer> {
}
