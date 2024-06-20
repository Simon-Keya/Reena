package com.restaurantmanagement.Reena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantmanagement.Reena.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
