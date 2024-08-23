package com.lab3.Authentication.and.PKI.controller;

import com.lab3.Authentication.and.PKI.dto.AuthRequest;
import com.lab3.Authentication.and.PKI.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> createToken(@RequestBody AuthRequest authRequest) {
        try {
            Map<String, String> tokenResponse = authenticationService.generateToken(authRequest);
            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
        }
    }
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Service is up and running");
    }
}
