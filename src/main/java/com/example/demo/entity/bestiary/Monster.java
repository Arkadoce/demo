package com.example.demo.entity.bestiary;

import com.example.demo.entity.Creature;
import com.example.demo.entity.Stats;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "bestiary")
public class Monster extends Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 1000)
    private String description;
    private List<String> keywords;

    @Enumerated(EnumType.STRING)
    private MonsterType type;

    @PositiveOrZero
    private Double challengeRating;

    public Monster() {}

    public Monster(String name, String description, Stats stats, CreatureSize size, MonsterType monsterType, int maxHp, int speed, double challengeRating, int armorClass) {
        super(name, stats, armorClass, maxHp, speed, size);
        this.description = description;
        this.type = monsterType;
        this.challengeRating = challengeRating;
    }

    public Double getChallengeRating() { return challengeRating; }
    public void setChallengeRating(Double challengeRating) {this.challengeRating = challengeRating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getKeywords() { return keywords; }
    public void setKeywords(List<String> keywords) { this.keywords = keywords; }

    public Long getId() { return id; }

    public MonsterType getType() { return type; }
    public void setType(MonsterType type) { this.type = type; }
}
