package com.egen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.entity.Billing;

@Repository
public interface BillingOrder extends JpaRepository<Billing, Integer> {

}
