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
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) CreatureSize size,
                               @RequestParam(required = false) MonsterType type,
                               @RequestParam(required = false) Double cr,
                               @RequestParam(required = false) String fragment,
                               Model model) {
        List<MonsterResponse> monsters = bestiaryService.getFiltered(name, size, type, cr);
        model.addAttribute("monsters", monsters);

        MonsterResponse selectedMonster = null;

        if (id != null) {
            selectedMonster = bestiaryService.getById(id);
        } else if (!monsters.isEmpty()) {
            selectedMonster = monsters.get(0);
        }

        model.addAttribute("selectedMonster", selectedMonster);

        if ("details".equals(fragment)) {
            return "bestiary/list :: monster-details";
        }

        return "bestiary/list"; // Папка bestiary, файл list.html
    }

}
