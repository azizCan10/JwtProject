package com.test.jwt.controller;

import com.test.jwt.dto.AuthRequest;
import com.test.jwt.dto.CreateUserRequest;
import com.test.jwt.service.JwtService;
import com.test.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.ok("Welcome!");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(authRequest.username()));
        }

        throw new UsernameNotFoundException("Username not found: " + authRequest.username());
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserString() {
        return ResponseEntity.ok("This is USER!");
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getAdminString() {
        return ResponseEntity.ok("This is ADMIN!");
    }

}
