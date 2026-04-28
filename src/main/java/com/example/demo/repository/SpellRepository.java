package com.example.demo.repository;

import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long>, JpaSpecificationExecutor<Spell> {
}
