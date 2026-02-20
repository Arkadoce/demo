package com.example.demo.entity;

import com.example.demo.entity.model.CreatureSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@MappedSuperclass
public abstract class Creature {

    @Column(nullable = false)
    @NotBlank
    private String name;
    @Positive
    private int armorClass;
    @Positive
    private int maxHp;
    @Positive
    private int currentHp;
    @Positive
    private int speed;
    @Positive
    private int tempHp;

    @Enumerated(EnumType.STRING)
    private CreatureSize size;

    @Embedded
    private Stats stats;

    public Creature() {}

    public Creature(String name, Stats stats, int armorClass, int maxHp, int speed, CreatureSize size) {
        this.name = name;
        this.stats = stats;
        this.armorClass = armorClass;
        this.maxHp = maxHp;
        this.speed = speed;
        this.size = size;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getArmorClass() { return armorClass; }
    public void setArmorClass(int armorClass) { this.armorClass = armorClass; }

    public int getMaxHp() { return maxHp; }
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }

    public int getCurrentHp() { return currentHp; }
    public void setCurrentHp(int currentHp) { this.currentHp = currentHp; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public int getTempHp() { return tempHp; }
    public void setTempHp(int tempHp) { this.tempHp = tempHp; }

    public CreatureSize getSize() { return size; }
    public void setSize(CreatureSize size) { this.size = size; }

    public Stats getStats() { return stats; }
    public void setStats(Stats stats) { this.stats = stats; }
}
