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

            // 1. Поиск по имени (игнорируя регистр)
            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            // 2. Фильтр по Типу (строгое совпадение Enum)
            if (type != null && !type.isBlank()) {
                predicates.add(cb.equal(root.get("type"), MonsterType.valueOf(type)));
            }

            // 3. Фильтр по Размеру
            if (size != null && !size.isBlank()) {
                predicates.add(cb.equal(root.get("size"), CreatureSize.valueOf(size)));
            }

            // 4. Фильтр по Опасности (CR) - От и До! (Это очень удобно для Мастера)
            if (minCr != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("challengeRating"), minCr));
            }
            if (maxCr != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("challengeRating"), maxCr));
            }

            // Собираем все условия через AND
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
