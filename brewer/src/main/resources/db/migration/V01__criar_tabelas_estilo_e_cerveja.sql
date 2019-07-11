CREATE TABLE estilo
(
    id serial NOT NULL,
    nome character varying(50),
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE TABLE cerveja (
    id SERIAL NOT NULL,
    sku VARCHAR(50) NOT NULL,
    nome VARCHAR(80) NOT NULL,
    descricao varchar(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    teor_alcoolico DECIMAL(10, 2) NOT NULL,
    comissao DECIMAL(10, 2) NOT NULL,
    sabor VARCHAR(50) NOT NULL,
    origem VARCHAR(50) NOT NULL,
    id_estilo BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_estilo) REFERENCES estilo(id)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

INSERT INTO estilo VALUES ('Amber Lager');
INSERT INTO estilo VALUES ('Dark Lager');
INSERT INTO estilo VALUES ('Pale Lager');
INSERT INTO estilo VALUES ('Pilsner');


select VERSION();