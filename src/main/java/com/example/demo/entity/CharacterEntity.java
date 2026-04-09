package com.example.demo.entity;

import com.example.demo.entity.model.CreatureSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="characters")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CharacterEntity extends Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1) @Max(20)
    private int level;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;

    public int bm(){
        if (level >= 17) return 6;
        if (level >= 13) return 5;
        if (level >= 9)  return 4;
        if (level >= 5)  return 3;
        return 2;
    }
}
