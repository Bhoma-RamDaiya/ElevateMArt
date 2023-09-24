package com.example.ElevateMart.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ItemRequest {
    String customerEmail;
    int requiredQuantity;
    int productId;
}
