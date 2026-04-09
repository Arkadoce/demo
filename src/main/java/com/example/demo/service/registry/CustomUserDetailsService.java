package com.example.demo.service.registry;

import com.example.demo.repository.registry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.entity.registry.User;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Ищем твою сущность в базе
        User userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

        // 2. Создаем и возвращаем объект UserDetails, который понимает Spring Security
        return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword()) // тут должен быть BCrypt хеш
                .roles(userEntity.getRole().name().replace("ROLE_", "")) // Spring сам добавит ROLE_
                .disabled(!userEntity.isEnabled()) // если у тебя есть поле enabled
                .build();
    }
}
