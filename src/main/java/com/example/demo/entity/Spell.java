package com.example.demo.entity;

import com.example.demo.entity.model.spell.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "spells")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;
    @NotBlank
    private String castingTime;
    @NotBlank
    private String distance;
    @NotBlank
    private String duration;

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
    @Column(columnDefinition = "text[]")
    private List<String> components;
    @Column(columnDefinition = "text[]")
    private List<String> races;

    @NotNull
    @Enumerated(EnumType.STRING)
    private School school;
    @Enumerated(EnumType.STRING)
    private DamageType damageType;
    @Enumerated(EnumType.STRING)
    private SavingThrow savingThrow;

    private boolean isRitual;
    private boolean isConcentration;

}
