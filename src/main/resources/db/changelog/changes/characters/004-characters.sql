CREATE TABLE characters(
    id BIGSERIAL PRIMARY KEY,
    level INT NOT NULL DEFAULT 1 CHECK (level >= 1 AND level <= 20),
    class_id BIGINT,

    name VARCHAR(255) NOT NULL,
    armor_class INT NOT NULL,
    health INT NOT NULL,
    speed INT DEFAULT 30,
    size VARCHAR(50),

    str INT DEFAULT 10,
    dex INT DEFAULT 10,
    con INT DEFAULT 10,
    wis INT DEFAULT 10,
    int INT DEFAULT 10,
    cha INT DEFAULT 10,

    alignment VARCHAR(100),

    languages TEXT[],
    skills TEXT[],
    saving_throws TEXT[],

    CONSTRAINT fk_character_class
        FOREIGN KEY (class_id)
        REFERENCES character_classes (id)
        ON DELETE SET NULL
);