CREATE DATABASE IF NOT EXISTS safm_db;
USE safm_db;

-- 🔹 Tabla de categorías
CREATE TABLE category (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        description VARCHAR(255)
);

-- 🔹 Tabla de productos
CREATE TABLE product (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(150) NOT NULL,
        price DECIMAL(10,2) NOT NULL,
        stock INT NOT NULL,
        category_id BIGINT,
        FOREIGN KEY (category_id) REFERENCES category(id)
);

-- 🔹 Tabla de usuarios
CREATE TABLE users (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(100) NOT NULL,
        email VARCHAR(150) UNIQUE NOT NULL,
        password VARCHAR(255) NOT NULL
);