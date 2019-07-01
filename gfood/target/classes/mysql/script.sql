-- CREATE DATABASE gfood;

-- SHOW DATABASE gfood;

USE gfood;

CREATE TABLE cliente (
	id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200),
    PRIMARY KEY (id)
);

SELECT * FROM cliente;

INSERT INTO cliente (nome, endereco)
VALUES ("Jorge Ferreira", "Rua Tecel José Ferreira Lameirão 77 - Apto 44");

INSERT INTO cliente (nome, endereco)
VALUES ("Hélio Pierazzo", "Avenida Yoshi Nomiyama, 398");