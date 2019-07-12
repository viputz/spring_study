CREATE TABLE estilo ( 
	id SERIAL NOT NULL, 
	nome VARCHAR(50), 
	PRIMARY KEY (id) 
);

CREATE TABLE cerveja ( 
	id SERIAL NOT NULL, 
	sku VARCHAR(50) NOT NULL, 
	nome VARCHAR(50) NOT NULL, 
	descricao TEXT NOT NULL,
	valor money NOT NULL,
	teor_alcoolico decimal(10,2),
	comissao decimal(10,2),
	sabor varchar(50),
	origem varchar(50),	
	id_estilo BIGINT NOT NULL, 
	PRIMARY KEY (id), 
	CONSTRAINT id_estilo FOREIGN KEY (id_estilo) REFERENCES estilo (id) 
);

INSERT INTO estilo (nome)
VALUES ('Amber Lager');

INSERT INTO estilo (nome)
VALUES ('Dark Lager');

INSERT INTO estilo (nome)
VALUES ('Pale Lager');

INSERT INTO estilo (nome)
VALUES ('Pilsner');