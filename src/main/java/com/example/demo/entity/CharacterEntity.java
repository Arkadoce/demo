package com.example.demo.entity;

import com.example.demo.entity.model.CreatureSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="characters")
public class CharacterEntity extends Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(1) @Max(20)
    private int level;

    protected CharacterEntity() {};

    public CharacterEntity(String name, Stats stats, int armorClass, int maxHp, int speed, CreatureSize size, int level){
        super(name,stats,armorClass,maxHp,speed,size);
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
