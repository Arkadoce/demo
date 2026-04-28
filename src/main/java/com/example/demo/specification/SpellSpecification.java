package com.example.demo.specification;

import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.School;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class SpellSpecification {

    public static Specification<Spell> filterSpell(String name, Integer level, String characterClass,
                                                   String school) {
        return(root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (level != null && level >= 0 && level <= 9) {
                predicates.add(cb.equal(root.get("level"), level));
            }

            if (characterClass != null && !characterClass.isBlank()) {
                predicates.add(cb.equal(root.join("classes").get("name"), characterClass));
            }

            if (school != null && !school.isBlank()) {
                try {
                    School schoolEnum = School.valueOf(school.toUpperCase());
                    predicates.add(cb.equal(root.get("school"), schoolEnum));
                } catch (IllegalArgumentException e) {}
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
