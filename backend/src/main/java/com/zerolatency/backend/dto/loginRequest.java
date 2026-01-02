package com.zerolatency.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginRequest {
    private String username;
    private String password;
}
