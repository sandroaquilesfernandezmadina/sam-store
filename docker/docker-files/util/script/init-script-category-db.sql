CREATE DATABASE IF NOT EXISTS category_db;
USE category_db;

CREATE TABLE category
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);