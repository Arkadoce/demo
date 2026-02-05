package com.example.demo.entity.Character.Race.RaceAbility;

import com.example.demo.entity.Character.Race.RaceEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "race_abilities")
@Getter
public class RaceAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private AbilityType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    private RaceEntity race;

    protected RaceAbility() {
    }

    public RaceAbility(String name, String description, AbilityType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }
}
