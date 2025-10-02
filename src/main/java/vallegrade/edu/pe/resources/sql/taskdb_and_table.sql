CREATE DATABASE bd_formulario;

USE bd_formulario;

CREATE TABLE estudiante (
    id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    documento ENUM('DNI','CNE') NOT NULL,
    numero_documento VARCHAR(20) NOT NULL UNIQUE,
    institucion VARCHAR(150) NOT NULL,
    grado ENUM('2','3') NOT NULL
);

-- Datos de ejemplo
INSERT INTO estudiante (nombre, apellidos, documento, numero_documento, institucion, grado)
VALUES
('Ana', 'Pérez López', 'DNI', '12345678', 'I.E. San Vicente', '2'),
('Luis', 'García Ramos', 'CNE', 'CNE998877', 'I.E. Santa Rosa', '3');
