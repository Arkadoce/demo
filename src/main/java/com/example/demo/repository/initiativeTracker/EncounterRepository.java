package com.example.demo.repository.initiativeTracker;

import com.example.demo.entity.initiativeTracker.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Long> {
}
