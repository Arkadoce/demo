package com.example.demo.controller.registry;

import com.example.demo.dto.registry.RegistrationRequest;
import com.example.demo.service.registry.AuthService;
import jakarta.servlet.Registration;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Регистрация прошла успешно");
    }
}
