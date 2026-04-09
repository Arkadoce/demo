CREATE TABLE bestiary (

    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    type VARCHAR(50),
    challenge_rating DOUBLE PRECISION,
    armor_class INT NOT NULL,
    health INT NOT NULL,
    speed INT NOT NULL,
    size VARCHAR(50),
    str INT DEFAULT 10,
    dex INT DEFAULT 10,
    con INT DEFAULT 10,
    int INT DEFAULT 10,
    wis INT DEFAULT 10,
    cha INT DEFAULT 10
);