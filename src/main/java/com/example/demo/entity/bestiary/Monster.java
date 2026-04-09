package com.example.demo.entity.bestiary;

import com.example.demo.entity.Creature;
import com.example.demo.entity.Stats;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
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

    @Enumerated(EnumType.STRING)
    private MonsterType type;

    @PositiveOrZero
    private Double challengeRating;

    public Monster(String name, String description, Stats stats, CreatureSize size, MonsterType type, int health, int armorClass, Double challengeRating) {
        super(name, stats, armorClass, health, size);
        this.description = description;
        this.type = type;
        this.challengeRating = challengeRating;
    }
}
