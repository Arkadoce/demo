package com.example.demo.service;

import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.CharacterEntity;
import com.example.demo.entity.Stats;
import com.example.demo.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository repository;

    public List<CharacterEntity> getAll() {
        return repository.findAll();
    }

    public CharacterClass getByName(String name) {
        return repository.findByName(name);
    }
}
