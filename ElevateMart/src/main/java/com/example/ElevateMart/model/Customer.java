package com.example.ElevateMart.model;

import com.example.ElevateMart.Enum.Gender;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true)
    String mobileNo;

    @Column(unique = true)
    String emailId;

    String Adress;



    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Card> card = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<OrderEntity>orders = new ArrayList<>();

}
