package com.example.demo.controller.frontend.bestiary;

import com.example.demo.service.BestiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/bestiary-page")
@RequiredArgsConstructor
public class BestiaryHtmlController {

    private final BestiaryService bestiaryService;

    @GetMapping
    public String showBestiary(//@RequestParam(required = false) Long id,
                               //@RequestParam(required = false) String search,,
                               Model model) {
        //List<>
        model.addAttribute("monsters", bestiaryService.getAll());
        return "bestiary/list"; // Папка bestiary, файл list.html
    }

}
