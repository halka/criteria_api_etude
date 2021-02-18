CREATE TABLE IF NOT EXISTS users (
    id serial NOT NULL,
    name VARCHAR(255),
    status VARCHAR(255),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
