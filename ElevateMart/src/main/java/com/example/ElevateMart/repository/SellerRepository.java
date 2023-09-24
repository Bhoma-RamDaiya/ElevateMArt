package com.example.ElevateMart.repository;

import com.example.ElevateMart.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller , Integer> {
  public  Seller findByEmailId(String emailId);
   }
