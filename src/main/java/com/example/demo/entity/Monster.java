package com.example.demo.entity;

import com.example.demo.entity.model.MonsterType;
import com.example.demo.entity.model.Size;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Bestiary")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    private List<String> keywords;

    @Embedded
    private Stats stats;

    private Size size;
    private MonsterType type;

    private int health;
    private int armorClass;
    private Double challengeRating;

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getArmorClass() { return armorClass; }
    public void setArmorClass(int armorClass) { this.armorClass = armorClass; }

    public Double getChallengeRating() { return challengeRating; }
    public void setChallengeRating(Double challengeRating) {this.challengeRating = challengeRating; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getKeywords() { return keywords; }
    public void setKeywords(List<String> keywords) { this.keywords = keywords; }

    public Stats getStats() { return stats; }
    public void setStats(Stats stats) { this.stats = stats; }

    public Long getId() { return id; }

    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }

    public MonsterType getType() { return type; }
    public void setType(MonsterType type) { this.type = type; }
}
