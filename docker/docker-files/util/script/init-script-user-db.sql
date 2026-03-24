CREATE DATABASE IF NOT EXISTS user_db;
USE user_db;

CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100)        NOT NULL,
    email    VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);