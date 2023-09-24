package com.example.ElevateMart.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "item_info")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    int total;

    int requiredQuantity;
@ManyToOne
        @JoinColumn
   Cart cart;

@ManyToOne
        @JoinColumn
    Product product;
@ManyToOne
@JoinColumn
OrderEntity orders;

}
