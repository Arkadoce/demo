package com.example.demo.repository.bestiary;

import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import org.springframework.data.jpa.domain.Specification;

public class MonsterSpecifications {

    public static Specification<Monster> hasSize(CreatureSize size) {
        return (root, query, cb) ->
                size == null ? null : cb.equal(root.get("size"), size);
    }

    public static Specification<Monster> hasType(MonsterType type) {
        return (root, query, cb) ->
                type == null ? null : cb.equal(root.get("type"), type);
    }

    public static Specification<Monster> hasCr(Double cr) {
        return (root, query, cb) ->
                cr == null ? null : cb.equal(root.get("challengeRating"), cr);
    }

    public static Specification<Monster> nameLike(String name) {
        return (root, query, cb) -> (name == null || name.isEmpty())
                ? null
                : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
}
