package com.test.jwt.dto;

import com.test.jwt.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private Set<Role> authorities;
}
