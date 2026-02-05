package com.example.demo.controller;

import com.example.demo.dto.RaceAbilityDto;
import com.example.demo.dto.RaceBonusDto;
import com.example.demo.dto.RaceResponse;
import com.example.demo.entity.Character.Race.RaceEntity;
import com.example.demo.repository.RaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/races")
public class RaceController {

    private final RaceRepository raceRepo;

    public RaceController(RaceRepository raceRepo) {
        this.raceRepo = raceRepo;
    }

    // ✅ Для HTML: загрузить список рас + abilities + bonuses
    @GetMapping
    public List<RaceResponse> list() {
        return raceRepo.findAll().stream()
                .map(RaceController::toDto)
                .toList();
    }

    // (не обязательно, но удобно для отладки)
    @GetMapping("/{id}")
    public RaceResponse get(@PathVariable Long id) {
        RaceEntity race = raceRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Race not found: " + id));
        return toDto(race);
    }

    private static RaceResponse toDto(RaceEntity r) {
        var abilities = r.getAbilities().stream()
                .map(a -> new RaceAbilityDto(
                        a.getId(),
                        a.getName(),
                        a.getDescription(),
                        a.getType() == null ? null : a.getType().name()
                ))
                .toList();

        var bonuses = r.getBonuses().stream()
                .map(b -> new RaceBonusDto(
                        b.getId(),
                        b.getType() == null ? null : b.getType().name(),
                        b.getStat() == null ? null : b.getStat().name(),
                        b.getValue()
                ))
                .toList();

        return new RaceResponse(
                r.getId(),
                r.getCode(),
                r.getName(),
                r.getDescription(),
                r.getSpeed(),
                r.getSize() == null ? null : r.getSize().name(),
                r.getDarkvision(),
                abilities,
                bonuses
        );
    }
}
