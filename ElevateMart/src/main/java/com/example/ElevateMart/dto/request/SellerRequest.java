package com.example.ElevateMart.dto.request;

import com.example.ElevateMart.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder

public class SellerRequest {
    String name ;

    String panNo;

    String emailId;

    Gender gender;

    String mobNo;
}
