package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="characters")
public class CharacterEntity extends Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int level;

    protected CharacterEntity() {};

    public CharacterEntity(String name, Stats stats, int level){
        super(name,stats);
        this.level=level;
    }

    public int bm(){
        if (level >= 17) return 6;
        if (level >= 13) return 5;
        if (level >= 9)  return 4;
        if (level >= 5)  return 3;
        return 2;
    }

    public int getLevel(){
        return level;
    }
    public void setLevel(int level) { this.level = level; }

    public long getId() {
        return id;
    }
}
