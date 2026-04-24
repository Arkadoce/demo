package com.example.demo.controller.frontend.bestiary;

import com.example.demo.dto.MonsterResponse;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.service.BestiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/bestiary")
@RequiredArgsConstructor
public class BestiaryHtmlController {

    private final BestiaryService bestiaryService;

    @GetMapping
    public String showBestiary(@RequestParam(required = false) Long id,
                               @RequestParam(required = false) String fragment,
                               Model model) {
        model.addAttribute("monsters", bestiaryService.getAll());

        if (id != null) {
            model.addAttribute("selectedMonster", bestiaryService.getById(id));
        }

        if ("details".equals(fragment)) {
            return "bestiary/card :: monster-details";
        }

        return "bestiary/list";
    }

}
