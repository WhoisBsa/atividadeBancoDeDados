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
