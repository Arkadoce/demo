package com.example.demo.service.registry;

import com.example.demo.dto.registry.RegistrationRequest;
import com.example.demo.entity.model.role.Role;
import com.example.demo.entity.registry.User;
import com.example.demo.repository.registry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest request) {

        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("Пользователь уже существует");
        }

        User user = new User();
        user.setUsername(request.username());

        user.setPassword(passwordEncoder.encode(request.password()));

        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
    }


}
