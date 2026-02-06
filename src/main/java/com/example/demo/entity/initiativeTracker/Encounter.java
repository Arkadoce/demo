package com.example.demo.entity.initiativeTracker;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int currentTurnIndex;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("initiative DESC")
    private List<CombatParticipant> participants;

    public Encounter() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCurrentTurnIndex() { return currentTurnIndex; }
    public void setCurrentTurnIndex(int currentTurnIndex) { this.currentTurnIndex = currentTurnIndex; }

    public Long getId() { return id; }

    public List<CombatParticipant> getParticipants() { return participants; }
    public void setParticipants(List<CombatParticipant> participants) { this.participants = participants; }
}
