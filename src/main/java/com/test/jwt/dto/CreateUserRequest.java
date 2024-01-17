package com.test.jwt.dto;

import com.test.jwt.enums.Role;

import java.util.Set;

public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {
}
