package com.example.demo.controller;

import com.example.demo.dto.MonsterResponse;
import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.service.BestiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bestiary")
@RequiredArgsConstructor
public class BestiaryController {

    private final BestiaryService bestiaryService;

    @GetMapping("/filter")
    public List<MonsterResponse> filter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) Double minCr,
            @RequestParam(required = false) Double maxCr) {

        return bestiaryService.getFilteredMonsters(name, type, size, minCr, maxCr);
    }

}

