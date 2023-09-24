package com.example.ElevateMart.dto.reponse;

import com.example.ElevateMart.Enum.ProductCatagory;
import com.example.ElevateMart.Enum.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ProductResponse {
    String sellerName;
    String productName;

    ProductCatagory catagory;

    int price ;

    int avilavbleQuantity;

    ProductStatus productStatus;


}
