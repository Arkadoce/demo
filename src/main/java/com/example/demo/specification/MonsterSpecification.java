package com.example.demo.specification;

import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class MonsterSpecification {

    public static Specification<Monster> filterMonster(String name, String type, String size, Double minCr, Double maxCr) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (type != null && !type.isBlank()) {
                predicates.add(cb.equal(root.get("type"), MonsterType.valueOf(type)));
            }

            if (size != null && !size.isBlank()) {
                predicates.add(cb.equal(root.get("size"), CreatureSize.valueOf(size)));
            }

            if (minCr != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("challengeRating"), minCr));
            }
            if (maxCr != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("challengeRating"), maxCr));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
