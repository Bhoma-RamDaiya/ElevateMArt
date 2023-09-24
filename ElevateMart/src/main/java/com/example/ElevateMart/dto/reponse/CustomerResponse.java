package com.example.ElevateMart.dto.reponse;

import com.example.ElevateMart.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class CustomerResponse {
    String name;

    String emailId;

    String mobNo;


    Gender gender;
}
