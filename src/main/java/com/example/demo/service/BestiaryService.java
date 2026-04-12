package com.example.demo.service;

import com.example.demo.dto.MonsterResponse;
import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.mapper.MonsterMapper;
import com.example.demo.repository.bestiary.BestiaryRepository;
import com.example.demo.repository.bestiary.MonsterSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.rmi.MarshalledObject;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BestiaryService {

    private final BestiaryRepository bestiaryRepository;
    private final MonsterMapper mapper;

    public List<MonsterResponse> getAll() {
        return bestiaryRepository.findAll().stream()
                .map(mapper::toResponse).toList();
    }

    public List<MonsterResponse> getFiltered(String name, CreatureSize size, MonsterType type, Double cr) {
        Specification<Monster> spec = Specification
                .where(MonsterSpecifications.nameLike(name))
                .and(MonsterSpecifications.hasSize(size))
                .and(MonsterSpecifications.hasType(type))
                .and(MonsterSpecifications.hasCr(cr));

        return bestiaryRepository.findAll(spec).stream()
                .map(mapper::toResponse)
                .toList();
    }

    public MonsterResponse getById(Long id) {
        return mapper.toResponse(bestiaryRepository.findById(id)
                .orElseThrow());
    }
}

