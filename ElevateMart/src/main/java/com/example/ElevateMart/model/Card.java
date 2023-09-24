package com.example.ElevateMart.model;

import com.example.ElevateMart.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Setter
@Builder
@Table(name = "card")
public class Card {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String cardNo;

    int cvv;

    @Enumerated(EnumType.STRING)
    CardType cardType;

    Date validTill;
  @ManyToOne
    @JoinColumn
    Customer customer;


}
