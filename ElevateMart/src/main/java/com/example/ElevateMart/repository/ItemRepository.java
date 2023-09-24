package com.example.ElevateMart.repository;

import com.example.ElevateMart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item ,Integer> {
}
