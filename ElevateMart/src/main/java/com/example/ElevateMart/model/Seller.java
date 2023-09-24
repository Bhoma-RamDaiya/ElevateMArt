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
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name ;

    @Column(unique = true)
    String panNo;

//    int age ;

    @Column(unique = true )
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true )
    String mobNo;

    @OneToMany(mappedBy = "seller" , cascade = CascadeType.ALL)
      List<Product>products = new ArrayList<>();

}
