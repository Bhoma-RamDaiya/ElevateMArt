package com.example.ElevateMart.dto.reponse;

import com.example.ElevateMart.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Builder
public class SellerResponse {
    String name ;

    String panNo;

    String emailId;

    Gender gender;

    String mobNo;
}
