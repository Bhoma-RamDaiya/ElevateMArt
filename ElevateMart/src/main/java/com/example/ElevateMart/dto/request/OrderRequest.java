package com.example.ElevateMart.dto.request;

import com.example.ElevateMart.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class OrderRequest {
    String customerEmail;

    int productId;

    int cvv;

   String cardUsed;

    int requiredQuantity;

}
