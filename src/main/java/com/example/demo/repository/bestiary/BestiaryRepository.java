package com.example.demo.repository.bestiary;

import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.MonsterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestiaryRepository extends JpaRepository<Monster, Long>, JpaSpecificationExecutor<Monster> {
}




