CREATE TABLE subclasses (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    class_id BIGINT NOT NULL,
    CONSTRAINT fk_subclass_class FOREIGN KEY (class_id) REFERENCES character_classes (id) ON DELETE CASCADE
);