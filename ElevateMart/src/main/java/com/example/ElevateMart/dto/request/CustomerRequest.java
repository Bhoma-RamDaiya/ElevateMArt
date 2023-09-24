package com.example.ElevateMart.dto.request;

import com.example.ElevateMart.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class CustomerRequest {
    String name;

    Gender gender;

    String mobNo;

    String emailId;

    String address;

}
