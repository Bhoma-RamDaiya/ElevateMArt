package com.example.ElevateMart.model;

import com.example.ElevateMart.Enum.ProductCatagory;
import com.example.ElevateMart.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    @Enumerated(EnumType.STRING)
    ProductCatagory catagory;

    int price ;

    int avilavbleQuantity;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @ManyToOne
@JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();


}
