package com.example.demo.entity;

import com.example.demo.entity.model.spell.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spells")
@Getter
@Setter
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Min(0) @Max(9)
    private int level;
    @ManyToMany
    @JoinTable(
        name = "spell_classes",
        joinColumns = @JoinColumn(name = "spell_id"),
        inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<CharacterClass> classes = new HashSet<>();
    @NotNull
    @Enumerated(EnumType.STRING)
    private School school;
    private boolean isRitual;
    private boolean isConcentration;
    @NotNull
    @Enumerated(EnumType.STRING)
    private DamageType damageType;
    @Enumerated(EnumType.STRING)
    private SavingThrow savingThrow;
    @Enumerated(EnumType.STRING)
    private Components components;

    public Spell() {}
}
