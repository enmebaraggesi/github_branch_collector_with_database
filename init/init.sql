CREATE TABLE IF NOT EXISTS REPO
(
    id    BIGSERIAL PRIMARY KEY,
    owner VARCHAR(255)        NOT NULL,
    name  VARCHAR(255) UNIQUE NOT NULL
);