CREATE TABLE class_features(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    level INT NOT NULL CHECK (level >= 1 AND level <= 20),
    class_id BIGINT NOT NULL,
    CONSTRAINT fk_feature_class FOREIGN KEY (class_id) REFERENCES character_classes(id) ON DELETE CASCADE
);