package com.example.ElevateMart.dto.reponse;

import com.example.ElevateMart.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class CardResponse {
    String customerName ;

    String CardNo;

    Date validTill;

    CardType cardType;
}
