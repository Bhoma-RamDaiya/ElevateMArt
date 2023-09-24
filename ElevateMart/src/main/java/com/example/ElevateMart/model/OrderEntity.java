package com.example.ElevateMart.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "order_info")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String orderId; //uuid

    @CreationTimestamp
    Date OrderDate;

    String cardUsed;

    int totalOrder;
     @ManyToOne
             @JoinColumn
    Customer customer;

     @OneToMany(mappedBy = "orders" , cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
//     public void addItem(Item item){
//         items = new ArrayList<>();
//         items.add(item);
//     }

}
