package com.example.demo.entity.Race;

import com.example.demo.entity.Race.RaceAbility.RaceAbility;
import com.example.demo.entity.model.Size;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="race",
        indexes = {
                @Index(name="idx_race_code", columnList = "code")
        }
)
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
    private List<RaceAbility> abilities = new ArrayList<>();

    public void addAbility(RaceAbility ability){
        abilities.add(ability);
        ability.setRace(this);
    }

    @OneToMany(
            mappedBy = "race",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RaceBonus> bonuses = new ArrayList<>();

    public void addBonus(RaceBonus bonus){
        bonuses.add(bonus);
        bonus.setRace(this);
    }

}
