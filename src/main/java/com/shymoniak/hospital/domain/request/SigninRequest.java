package com.shymoniak.hospital.domain.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SigninRequest {

    private String username;
    private String password;
}
