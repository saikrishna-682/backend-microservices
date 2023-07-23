CREATE TABLE IF NOT EXISTS customer(
    id BIGSERIAL  PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    age int NOT NULL
);