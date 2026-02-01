package com.example.demo.service;

import com.example.demo.entity.CharacterEntity;
import com.example.demo.entity.Stats;
import com.example.demo.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CharacterService {

    private final CharacterRepository repo;

    public CharacterService(CharacterRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public CharacterEntity create(String name, int level, Stats stats) {
        validateName(name);
        validateLevel(level);

        if (stats == null) {
            // дефолтные статы, если не передали
            stats = new Stats(10, 10, 10, 10, 10, 10);
        }

        CharacterEntity entity = new CharacterEntity(name, level, stats);
        return repo.save(entity);
    }

    // READ - list
    public List<CharacterEntity> list() {
        return repo.findAll();
    }

    // READ - by id
    public CharacterEntity get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Character not found: " + id));
    }

    // UPDATE (частично: если параметр null/0 - не меняем)
    public CharacterEntity update(Long id, String name, Integer level, Stats stats) {
        CharacterEntity entity = get(id);

        if (name != null) {
            validateName(name);
            entity.setName(name);
        }

        if (level != null) {
            validateLevel(level);
            entity.setLevel(level);
        }

        if (stats != null) {
            entity.setStats(stats); // нужно добавить setStats в Entity (см. ниже)
        }

        return repo.save(entity);
    }

    // DELETE
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Character not found: " + id);
        }
        repo.deleteById(id);
    }

    // LEVEL UP
    public CharacterEntity levelUp(Long id) {
        CharacterEntity entity = get(id);

        int next = entity.getLevel() + 1;
        validateLevel(next);

        entity.lvlUp();
        return repo.save(entity);
    }

    // ===== validators =====

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (name.length() > 60) {
            throw new IllegalArgumentException("name is too long (max 60)");
        }
    }

    private void validateLevel(int level) {
        if (level < 1 || level > 20) {
            throw new IllegalArgumentException("level must be in range 1..20");
        }
    }
}
