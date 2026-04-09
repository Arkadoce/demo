package com.example.demo.entity.initiativeTracker;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CombatParticipant {

    @NotBlank
    private String name;
    @Positive
    private int initiative;
    @PositiveOrZero
    private int currentHp;
    @Positive
    private int armor_class;
}
