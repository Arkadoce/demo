package com.example.demo.controller.registry;

import com.example.demo.dto.registry.RegistrationRequest;
import com.example.demo.service.registry.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 1. Показать страницу регистрации
    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        // Добавляем пустой объект запроса, чтобы Thymeleaf мог привязать к нему поля формы
        model.addAttribute("registrationRequest", new RegistrationRequest("", ""));
        return "register"; // ищет templates/register.html
    }

    // 2. Обработать отправку формы
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registrationRequest") RegistrationRequest request,
                           Model model) {
        try {
            authService.register(request);
            // Если всё ок — идем на логин с пометкой об успехе
            return "redirect:/login?success";
        } catch (RuntimeException e) {
            // Если юзер уже есть или другая ошибка — возвращаемся на форму с текстом ошибки
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    // 3. Страница логина
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
