package com.crypto.backend.auth;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}
