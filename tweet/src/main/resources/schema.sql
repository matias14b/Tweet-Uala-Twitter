DROP table if exists tweet;

CREATE TABLE tweet (
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    mensaje             VARCHAR(280) NOT NULL,
    Usuario_creador_id INT NOT NULL,
    fecha_creacion DATETIME NOT NULL
);