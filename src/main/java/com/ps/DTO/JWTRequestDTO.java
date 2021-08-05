package com.ps.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTRequestDTO {
    private String userName;
    private  String  userPassword;
}
