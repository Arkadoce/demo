package com.example.demo.service;

import com.example.demo.dto.MonsterResponse;
import com.example.demo.entity.bestiary.Monster;
import com.example.demo.mapper.MonsterMapper;
import com.example.demo.repository.bestiary.BestiaryRepository;
import com.example.demo.specification.MonsterSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BestiaryService {

    private final BestiaryRepository bestiaryRepository;
    private final MonsterMapper mapper;

    public List<MonsterResponse> getFilteredMonsters(String name, String type, String size, Double minCr, Double maxCr) {
        Specification<Monster> spec = MonsterSpecification.filterMonster(name, type, size, minCr, maxCr);

        List<Monster> monsters = bestiaryRepository.findAll(spec);

        return monsters.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public List<MonsterResponse> getAll() {
        return bestiaryRepository.findAll().stream()
                .map(mapper::toResponse).toList();
    }

    public MonsterResponse getById(Long id) {
        return mapper.toResponse(bestiaryRepository.findById(id)
                .orElseThrow());
    }
}

