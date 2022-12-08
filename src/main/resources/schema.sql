CREATE TABLE games(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    cover VARCHAR(255),
    votes BIGINT
);
