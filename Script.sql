CREATE DATABASE labbeach;

CREATE TABLE bairro(
id bigserial PRIMARY KEY,
nome varchar(150) NOT NULL,
descricao varchar(200),
populacao bigint
);

CREATE TABLE praia(
id bigserial PRIMARY KEY,
bairro_id bigint NOT NULL REFERENCES bairro(id),
nome varchar(150) NOT NULL,
acessibilidade varchar(10) NOT NULL,
status varchar(9) NOT null
);
