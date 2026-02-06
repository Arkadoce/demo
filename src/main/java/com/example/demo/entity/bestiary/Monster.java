package com.example.demo.entity.bestiary;

import com.example.demo.entity.Creature;
import com.example.demo.entity.model.MonsterType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bestiary")
public class Monster extends Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private List<String> keywords;

    @Enumerated(EnumType.STRING)
    private MonsterType type;

    private Double challengeRating;

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
