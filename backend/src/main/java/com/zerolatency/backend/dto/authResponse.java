package com.zerolatency.backend.dto;

import com.zerolatency.backend.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class authResponse {
    private String token;
    private Users user;
}
