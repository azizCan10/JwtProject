package com.test.jwt.dto;

public record AuthRequest(
        String username,
        String password
) {
}
