package com.example.demo.repository.initiativeTracker;

import com.example.demo.entity.initiativeTracker.CombatParticipant;
import com.example.demo.entity.initiativeTracker.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombatParticipantRepository extends JpaRepository<CombatParticipant, Long> {
}
