create database db_rh;

use db_rh;

create table tb_funcionarios(
	id bigint auto_increment,
    nome varchar(100) not null,
    idade int not null,
    cargo varchar(100) not null,
    salario decimal (9) not null,
    codFuncionario int(5) not null,
    primary key (id)
);
	select * from tb_funcionarios;

insert into tb_funcionarios(nome, idade, cargo, salario, codFuncionario) values ("Meliodas", 22, "Porteiro", 2000.00, 00200);
insert into tb_funcionarios(nome, idade, cargo, salario, codFuncionario) values ("Ban", 32, "Zelador", 3000.00, 00220);
insert into tb_funcionarios(nome, idade, cargo, salario, codFuncionario) values ("Merlin", 12, "Barista", 4000.00, 03200);
insert into tb_funcionarios(nome, idade, cargo, salario, codFuncionario) values ("Escanor", 42, "Camareiro", 3200.00, 04200);
insert into tb_funcionarios(nome, idade, cargo, salario, codFuncionario) values ("Hawk", 52, "Hoteleiro", 4200.00, 06200);
insert into tb_funcionarios(nome, idade, cargo, salario, codFuncionario) values ("Diane", 62, "Camareira", 2000.50, 06800);


select * from tb_funcionarios where salario > 2000;
select * from tb_funcionarios where salario < 2000;

update tb_funcionarios set cargo = "Zelador" where id =2; 


