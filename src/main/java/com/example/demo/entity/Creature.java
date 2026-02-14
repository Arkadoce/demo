package com.example.demo.entity;

import com.example.demo.entity.model.Size;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Creature {

    @Column(nullable = false)
    private String name;
    private int armorClass;
    private int maxHp;
    private int currentHp;
    private int speed;
    private int tempHp;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Embedded
    private Stats stats;

    public Creature() {}

    public Creature(String name, Stats stats) {
        this.name = name;
        this.stats = stats;
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

    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }

    public Stats getStats() { return stats; }
    public void setStats(Stats stats) { this.stats = stats; }
}
