CREATE TABLE IF NOT EXISTS users (
    id serial NOT NULL,
    name VARCHAR(255),
    status VARCHAR(255),
    device_id serial,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS devices(
    id serial NOT NULL,
    name VARCHAR(255),
    status VARCHAR(255),
    user_id serial,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id)
);
