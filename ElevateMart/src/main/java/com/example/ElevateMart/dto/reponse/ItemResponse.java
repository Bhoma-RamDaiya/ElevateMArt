package com.example.ElevateMart.dto.reponse;

import com.example.ElevateMart.Enum.ProductCatagory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ItemResponse {
    String itemName;
    int itemPrice;
    int quantityAdded;
    ProductCatagory productCatagory;
}
