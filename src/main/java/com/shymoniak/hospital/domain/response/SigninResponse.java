package com.shymoniak.hospital.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninResponse {

    private String token;
    private String role;
    private Long id;
}
