package com.example.ElevateMart.dto.reponse;

import com.example.ElevateMart.model.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class OrderResponse {
    String orderId ;//UUID

    Date orderDate;

    String cardUsed;

    int orderTotal ;

     String customerName;

     List<ItemResponse>item;
}
