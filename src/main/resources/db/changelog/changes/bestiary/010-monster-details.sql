ALTER TABLE bestiary
    ADD COLUMN alignment VARCHAR(100),
    ADD COLUMN habitat VARCHAR(255),
    ADD COLUMN languages VARCHAR(255),
    ADD COLUMN traits TEXT,
    ADD COLUMN actions TEXT,
    ADD COLUMN reactions TEXT,
    ADD COLUMN legendary_actions TEXT,
    ADD COLUMN saving_throws TEXT,        -- Спасброски (Лов +9, Тел +15...)
    ADD COLUMN skills TEXT,               -- Навыки (Магия +14, Обман +15...)
    ADD COLUMN damage_resistances TEXT,    -- Сопротивление к урону
    ADD COLUMN damage_immunities TEXT,     -- Иммунитет к урону
    ADD COLUMN condition_immunities TEXT,  -- Иммунитет к состояниям
    ADD COLUMN senses TEXT,               -- Чувства (Истинное зрение, Внимательность)
    ADD COLUMN experience_points INT,
    ADD COLUMN proficiency_bonus INT;