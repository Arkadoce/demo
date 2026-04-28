package com.example.demo.controller.frontend.spell;

import com.example.demo.service.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spells")
@AllArgsConstructor
public class SpellHtmlController {

    private final SpellService spellService;

    @GetMapping
    public String showSpells(@RequestParam(required = false) Long id,
                             @RequestParam(required = false) String fragment,
                             Model model) {
        model.addAttribute("spells", spellService.getAll());

        if (id != null) {
            model.addAttribute("selectedSpell", spellService.getSpellById(id));
        }

        if ("details".equals(fragment)) {
            return "spells/card :: spell-details";
        }

        return "spells/list";
    }
}
