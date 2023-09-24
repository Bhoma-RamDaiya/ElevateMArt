package com.example.ElevateMart.dto.request;

import com.example.ElevateMart.Enum.CardType;
import com.example.ElevateMart.dto.reponse.CardResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

public class CardRequest {
    String customerEmail;

    String cardNo;

    Date validTill;

    String cvv;

    CardType cardType;


}
