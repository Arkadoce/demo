package com.example.demo.entity.Race;


import com.example.demo.entity.Race.model.BonusType;
import com.example.demo.entity.model.StatType;
import jakarta.persistence.*;

@Entity
@Table(name = "race_bonus")
public class RaceBonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private BonusType type;

    @Enumerated(EnumType.STRING)
    private StatType stat;

    @Column(nullable = false)
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    private RaceEntity race;

    protected RaceBonus(){};

    void setRace(RaceEntity race) {
        this.race = race;
    }
}
