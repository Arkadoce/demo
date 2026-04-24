package com.example.demo.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/main")
public class MainController {

    @GetMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/classes")
    public String classesPage() {
        return "classes/list";
    }

    @GetMapping("/spells")
    public String spellsPage() {
        return "spells/list";
    }

    @GetMapping("/bestiary")
    public String bestiaryPage() {
        return "bestiary/list";
    }

    @GetMapping("/tracker")
    public String trackerPage() {
        return "tracker/index";
    }
}
