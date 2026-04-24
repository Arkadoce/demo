package com.example.demo.entity.bestiary;

import com.example.demo.entity.Creature;
import com.example.demo.entity.Stats;
import com.example.demo.entity.model.*;
import com.example.demo.entity.model.spell.DamageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "bestiary")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Monster extends Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "text[]")
    private List<String> traits;

    @Column(columnDefinition = "text[]")
    private List<String> actions;

    @Column(columnDefinition = "text[]")
    private List<String> reactions;

    @Column(columnDefinition = "text[]")
    private List<String> legendaryActions;

    @Column(columnDefinition = "text[]")
    private List<String> languages;

    @Column(columnDefinition = "text[]")
    private List<String> damageResistances;

    @Column(columnDefinition = "text[]")
    private List<String> damageImmunities;

    @Column(columnDefinition = "text[]")
    private List<String> conditionImmunities;

    @Column(nullable = false)
    private List<String> senses;

    private Integer experiencePoints;

    private Integer proficiencyBonus;

    @Enumerated(EnumType.STRING)
    private MonsterType type;

    private String habitat;

    @PositiveOrZero
    private Double challengeRating;

}
