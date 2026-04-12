package com.example.demo.entity;

import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.Language;
import com.example.demo.entity.model.Skill;
import com.example.demo.entity.model.spell.SavingThrow;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor
public abstract class Creature {

    @Column(nullable = false)
    @NotBlank
    private String name;
    @Positive
    private int armorClass;
    @Positive
    private int health;
    @Positive
    private int speed;

    @Enumerated(EnumType.STRING)
    private CreatureSize size;

    @Embedded
    private Stats stats;
    private List<SavingThrow> savingThrows;
    private String alignment;
    private List<Language> languages;
    private List<Skill> skills;

    public Creature(String name, Stats stats, int armorClass, int health, CreatureSize size) {
        this.name = name;
        this.stats = stats;
        this.armorClass = armorClass;
        this.health = health;
        this.size = size;
    }

    public Creature(String name, Stats stats, int armorClass, int health, int speed, CreatureSize size) {
        this.name = name;
        this.stats = stats;
        this.armorClass = armorClass;
        this.health = health;
        this.speed = speed;
        this.size = size;
    }

}
