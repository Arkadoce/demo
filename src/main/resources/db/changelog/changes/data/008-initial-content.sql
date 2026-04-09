INSERT INTO character_classes (name, description) VALUES
    ('Воин', 'Мастер ближнего боя, способный выстоять в любой заварушке.'),
    ('Волшебник', 'Маг, черпающий силу из древних фолиантов и знаний.');

-- 2. УМЕНИЯ КЛАССОВ (для таблицы уровней)
INSERT INTO class_features (name, description, level, class_id) VALUES
    ('Второе дыхание', 'Вы восстанавливаете 1к10 + уровень хитов.', 1, 1),
    ('Всплеск действий', 'Вы можете совершить еще одно действие.', 2, 1),
    ('Магическое восстановление', 'Восстановление ячеек на коротком отдыхе.', 1, 2);

-- 3. ЗАКЛИНАНИЯ
INSERT INTO spells (name, description, level, school, is_ritual, is_concentration, damage_type, components) VALUES
    ('Огненный шар', 'Огромный взрыв огня (8к6 урона).', 3, 'Воплощение', false, false, 'Огонь', 'В, С, М'),
    ('Магическая стрела', 'Три самонаводящихся дротика.', 1, 'Воплощение', false, false, 'Силовое поле', 'В, С');

-- 4. СВЯЗЬ ЗАКЛИНАНИЙ С КЛАССАМИ (Волшебнику - оба)
INSERT INTO spell_classes (spell_id, class_id) VALUES (1, 2), (2, 2);

-- 5. БЕСТИАРИЙ (Монстры)
INSERT INTO bestiary (name, description, type, challenge_rating, armor_class, health, speed, size, str, dex, con, int, wis, cha) VALUES
    ('Гоблин', 'Мелкое и злобное существо.', 'HUMANOID', 0.25, 15, 7, 30, 'SMALL', 8, 14, 10, 10, 8, 8),
    ('Бехолдер', 'Ужасный глаз с множеством лучей.', 'ABERRATION', 13.0, 18, 180, 20, 'LARGE', 10, 14, 18, 17, 15, 17);