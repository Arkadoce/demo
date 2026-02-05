package com.example.demo.entity.Character;

import com.example.demo.entity.Character.Race.RaceEntity;
import com.example.demo.entity.Stats;
import jakarta.persistence.*;

@Entity
@Table(name="characters",
        indexes = {
                @Index(name="idx_character_race", columnList="race_id")
        }
)
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected CharacterEntity(){};

    public CharacterEntity(String name, int level, Stats stats, RaceEntity race){
        this.name=name;
        this.level=level;
        this.stats=stats;
        this.race = race;
    }

    @Column(nullable=false)
    private String name;

    private int level;
    private int exp;


    @Embedded
    private Stats stats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    private RaceEntity race;

    public int bm(){
        if (level >= 17) return 6;
        if (level >= 13) return 5;
        if (level >= 9)  return 4;
        if (level >= 5)  return 3;
        return 2;
    }
    public RaceEntity getRace() { return race; }
    public void setRace(RaceEntity race) { this.race = race; }
    public String getName(){return name;}
    public int getLevel(){return level;}
    public Stats getStats() {return stats;}
    public int getExp() {return exp;}
    public void setExp(int exp) {this.exp = exp;}
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {this.level = level;}
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public long getId() {
        return id;
    }
}
