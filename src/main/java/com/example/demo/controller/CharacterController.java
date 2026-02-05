package com.example.demo.controller;

import com.example.demo.dto.CreateCharacterRequest;
import com.example.demo.dto.CharacterResponse;
import com.example.demo.entity.CharacterEntity;
import com.example.demo.mapper.CharacterMapper;
import com.example.demo.mapper.StatsMapper;
import com.example.demo.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    // ===== CREATE =====
    @PostMapping
    public CharacterResponse create(@RequestBody CreateCharacterRequest req) {
        CharacterEntity saved = service.create(
                req.name(),
                req.level(),
                StatsMapper.toStats(req.stats()),
                req.raceId()
        );
        return CharacterMapper.toResponse(saved);
    }

    // ===== READ ALL =====
    @GetMapping
    public List<CharacterResponse> list() {
        return service.list().stream()
                .map(CharacterMapper::toResponse)
                .toList();
    }

    // ===== READ ONE =====
    @GetMapping("/{id}")
    public CharacterResponse get(@PathVariable Long id) {
        return CharacterMapper.toResponse(service.get(id));
    }


    // ===== DELETE =====
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // ===== ACTION: LEVEL UP =====
    @PostMapping("/{id}/level-up")
    public CharacterResponse levelUp(@PathVariable Long id) {
        return CharacterMapper.toResponse(service.levelUp(id));
    }

    //Gain Exp
    @PostMapping("/{id}/gain-exp")
    public CharacterResponse gainExp(@PathVariable Long id, @RequestParam int amount) {
        return CharacterMapper.toResponse(service.gainExp(id, amount));
    }

}
