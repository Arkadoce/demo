package com.example.demo.repository;

import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
    public List<Spell> findByLevel(int level);
    public List<Spell> findByNameContainingIgnoreCase(String name);
    public List<Spell> findByDamageType(DamageType type);
    public List<Spell> findBySavingThrow(SavingThrow type);
    public List<Spell> findByConcentration(boolean concentration);
    public List<Spell> findByRitual(boolean ritual);
    public List<Spell> findBySchool(School school);
    public List<Spell> findByComponents(Components components);
    public List<Spell> findByClasses(CharacterClass classes);
}
