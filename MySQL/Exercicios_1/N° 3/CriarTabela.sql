use db_escola;

create table tb_estudantes(
ra bigint auto_increment,
nome varchar(40) not null,
idade int (2) not null,
nota double(10,2) not null,
turno varchar(5) not null,
serie varchar(3),

primary key(ra)
);

select * from tb_estudantes;