package com.example.demo.entity;

import com.example.demo.entity.model.spell.*;
import jakarta.persistence.*;

@Entity
@Table(name = "spells")
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private int level;
    private Classes classes;
    private School school;
    private boolean isRitual;
    private boolean isConcentration;
    private DamageType damageType;
    private SavingThrow savingThrow;
    private Components components;

    public Spell() {}

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {}

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public Classes getClasses() { return classes; }
    public void setClasses(Classes classes) { this.classes = classes; }

    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }

    public boolean isRitual() { return isRitual; }
    public void setRitual(boolean ritual) { this.isRitual = ritual; }

    public boolean isConcentration() { return isConcentration; }
    public void setConcentration(boolean concentration) { this.isConcentration = concentration; }

    public DamageType getDamageType() { return damageType; }
    public void setDamageType(DamageType damageType) { this.damageType = damageType; }

    public SavingThrow getSavingThrow() { return savingThrow; }
    public void setSavingThrow(SavingThrow savingThrow) { this.savingThrow = savingThrow; }

    public Components getComponents() { return components; }
    public void setComponents(Components components) { this.components = components; }
}
