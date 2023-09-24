package com.example.ElevateMart.repository;

import com.example.ElevateMart.Enum.ProductCatagory;
import com.example.ElevateMart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {

    @Query("select p from Product p where p.price >= :price and p.catagory = :catagory")
public List<Product> getProductByCategoryAndPriceGreaterThan(int price , ProductCatagory catagory);

}
