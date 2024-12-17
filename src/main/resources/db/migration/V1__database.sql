
CREATE TABLE IF NOT EXISTS users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(32) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       role VARCHAR(255),
                       created_at TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS maps (
                      id SERIAL PRIMARY KEY,
                      map_name VARCHAR(255) NOT NULL,
                      map_difficulty VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS monkeys_types (
                               id SERIAL PRIMARY KEY,
                               type_name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS monkeys (
                         id SERIAL PRIMARY KEY,
                         type_id INTEGER NOT NULL,
                         name VARCHAR(255),
                         upgrade_row1 INTEGER,
                         upgrade_row2 INTEGER,
                         upgrade_row3 INTEGER,
                         CONSTRAINT fk_monkey_type FOREIGN KEY (type_id) REFERENCES monkeys_types(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS posts (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255),
                       description TEXT,
                       map_img BYTEA,
                       map_id INTEGER,
                       user_id INTEGER NOT NULL,
                       created_at TIMESTAMP NOT NULL,
                       CONSTRAINT fk_post_map FOREIGN KEY (map_id) REFERENCES maps(id) ON DELETE SET NULL,
                       CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS follows (
                         id SERIAL PRIMARY KEY,
                         following_user_id INTEGER NOT NULL,
                         followed_user_id INTEGER NOT NULL,
                         followed_at TIMESTAMP NOT NULL,
                         CONSTRAINT fk_following_user FOREIGN KEY (following_user_id) REFERENCES users(id) ON DELETE CASCADE,
                         CONSTRAINT fk_followed_user FOREIGN KEY (followed_user_id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS monkey_hero (
                             id SERIAL PRIMARY KEY,
                             type_id INTEGER NOT NULL,
                             name VARCHAR(255) NOT NULL,
                             CONSTRAINT fk_monkey_hero_type FOREIGN KEY (type_id) REFERENCES monkeys_types(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS monkey_paragon (
                                id SERIAL PRIMARY KEY,
                                type_id INTEGER NOT NULL,
                                paragon_name VARCHAR(255) NOT NULL,
                                monkey_name VARCHAR(255) NOT NULL,
                                CONSTRAINT fk_monkey_paragon_type FOREIGN KEY (type_id) REFERENCES monkeys_types(id) ON DELETE CASCADE
);


INSERT INTO monkeys_types(type_name)
VALUES
    ('Primary'),
    ('Military'),
    ('Magic'),
    ('Support'),
    ('Paragon'),
    ('Hero');