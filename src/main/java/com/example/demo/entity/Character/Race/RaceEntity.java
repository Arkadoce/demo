package com.example.demo.entity.Character.Race;

import com.example.demo.entity.Character.Race.RaceAbility.RaceAbility;
import com.example.demo.entity.model.Size;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="race",
        indexes = {
                @Index(name="idx_race_code", columnList = "code")
        }
)
@Getter
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    protected RaceEntity(){};

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;
    private String description;

    private int speed;
    @Enumerated(EnumType.STRING)
    private Size size;
    private int Darkvision;

    @OneToMany(
            mappedBy = "race",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    public void addAbility(RaceAbility ability){
        abilities.add(ability);
        ability.setRace(this);
    }

    @OneToMany(
            mappedBy = "race",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    public void addBonus(RaceBonus bonus){
        bonuses.add(bonus);
        bonus.setRace(this);
    }
    @OneToMany(mappedBy="race", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<RaceAbility> abilities = new HashSet<>();

    @OneToMany(mappedBy="race", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<RaceBonus> bonuses = new HashSet<>();
}
