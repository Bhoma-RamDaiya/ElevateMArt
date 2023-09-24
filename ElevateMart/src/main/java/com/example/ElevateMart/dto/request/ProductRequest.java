package com.example.ElevateMart.dto.request;

import com.example.ElevateMart.Enum.ProductCatagory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ProductRequest {

    String sellerEmail;

    String productName;

    ProductCatagory catagory;

    int price ;

    int avilavbleQuantity;
}
