CREATE TABLE spells (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    casting_time VARCHAR(100) NOT NULL,
    distance VARCHAR(100) NOT NULL,
    duration VARCHAR(100) NOT NULL,
    level INT NOT NULL DEFAULT 0,

    components TEXT[],
    races TEXT[],

    school VARCHAR(50) NOT NULL,
    damage_type VARCHAR(50),
    saving_throw VARCHAR(50),

    is_ritual BOOLEAN DEFAULT false,
    is_concentration BOOLEAN DEFAULT false,
    is_cantrip BOOLEAN DEFAULT false
);

CREATE TABLE spell_classes (
    spell_id BIGINT NOT NULL,
    class_id BIGINT NOT NULL,
    PRIMARY KEY (spell_id, class_id),
    CONSTRAINT fk_spell FOREIGN KEY (spell_id) REFERENCES spells (id) ON DELETE CASCADE,
    CONSTRAINT fk_class FOREIGN KEY (class_id) REFERENCES character_classes (id) ON DELETE CASCADE
);
