package com.example.ElevateMart.repository;

import com.example.ElevateMart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    public Customer findByEmailId(String emailId);
}
