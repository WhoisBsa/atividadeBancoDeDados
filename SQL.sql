create database atividadeBD;

use atividadeBD;

create table cliente(
	id int primary key auto_increment,
    nome varchar(50),
    idade int,
    cpf varchar(14),
    endereco varchar(50),
    tel varchar(13)
);

create table usuario(
	login varchar(16) primary key,
    senha varchar(16)
);


INSERT INTO cliente (nome, idade, cpf, endereco, tel)
VALUES ('Ângelo', '16', '111.111.111-11', 'Avenida Bias Fortes', '32-99999-9999');

INSERT INTO cliente (nome, idade, cpf, endereco, tel)
VALUES ('Letícia', '20', '222.222.222-22', 'Rua Joaquim Carvalho', '31-88888-8888');

INSERT INTO cliente (nome, idade, cpf, endereco, tel)
VALUES ('Ivete', '60', '333.333.333-33', 'Rua Fernando Mineiro', '33-77777-7777');

INSERT INTO cliente (nome, idade, cpf, endereco, tel)
VALUES ('Elson', '50', '444.444.444-44', 'Rua Fracisco Maximinano', '34-66666-6666');

INSERT INTO usuario (login,senha)
VALUES ('Gustavo', '12345');

INSERT INTO usuario (login,senha)
VALUES ('Hemilio', '54321');
