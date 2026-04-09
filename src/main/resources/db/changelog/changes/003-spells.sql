CREATE TABLE spells (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    level INT NOT NULL CHECK (level >= 0 AND level <= 9),
    school VARCHAR(50) NOT NULL,
    is_ritual BOOLEAN NOT NULL,
    is_concentration BOOLEAN NOT NULL,
    damage_type VARCHAR(50) NOT NULL,
    saving_throw VARCHAR(50),
    components VARCHAR(50)
);

CREATE TABLE spell_classes (
    spell_id BIGINT NOT NULL,
    class_id BIGINT NOT NULL,
    PRIMARY KEY (spell_id, class_id),
    CONSTRAINT fk_spell FOREIGN KEY (spell_id) REFERENCES spells (id) ON DELETE CASCADE,
    CONSTRAINT fk_class FOREIGN KEY (class_id) REFERENCES character_classes (id) ON DELETE CASCADE
);
