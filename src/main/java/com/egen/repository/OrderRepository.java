package com.egen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	

}
