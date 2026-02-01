package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected CharacterEntity(){};

    public CharacterEntity(String name, int level,Stats stats){
        this.name=name;
        this.level=level;
        this.stats=stats;

    }

    @Column(nullable=false)
    private String name;

    private int level;

    @Embedded
    private Stats stats;

    public int bm(){
        if (level >= 17) return 6;
        if (level >= 13) return 5;
        if (level >= 9)  return 4;
        if (level >= 5)  return 3;
        return 2;
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public Stats getStats() {
        return stats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void lvlUp() {
        level++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
