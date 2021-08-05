package com.ps.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponseDTO {
    private String jwtToken;
    private Long expiresIn;
}
