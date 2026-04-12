package com.example.demo.entity.bestiary;

import com.example.demo.converter.StringListConverter;
import com.example.demo.entity.Creature;
import com.example.demo.entity.Stats;
import com.example.demo.entity.model.Condition;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.Habitat;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.entity.model.spell.DamageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bestiary")
@Getter @Setter @NoArgsConstructor
public class Monster extends Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 1000)
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Convert(converter = StringListConverter.class)
    private List<String> traits;
    @Column(nullable = false)
    @Convert(converter = StringListConverter.class)
    private List<String> actions;
    @Column(nullable = false)
    @Convert(converter = StringListConverter.class)
    private List<String> reactions;
    @Column(nullable = false)
    @Convert(converter = StringListConverter.class)
    private List<String> legendaryActions;
    private List<DamageType> damageResistances;
    private List<DamageType> damageImmunities;
    private List<Condition> conditionImmunities;
    @Column(nullable = false)
    @Convert(converter = StringListConverter.class)
    private List<String> senses;
    private Integer experience;

    @Enumerated(EnumType.STRING)
    private MonsterType type;
    @Enumerated(EnumType.STRING)
    private Habitat habitat;

    @PositiveOrZero
    private Double challengeRating;

    public Monster(String name, String description, Stats stats, int speed, CreatureSize size, MonsterType type, int health, int armorClass, Double challengeRating) {
        super(name, stats, armorClass, health, speed, size);
        this.description = description;
        this.type = type;
        this.challengeRating = challengeRating;
    }
}
