package com.example.ElevateMart.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class CartResponse {
    String customerName;
    int cartTotal;
    List<ItemResponse> itemResponses;

}
