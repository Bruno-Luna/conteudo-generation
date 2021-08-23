create database db_pizzaria_legal;

use db_pizzaria_legal;

create table tb_categoria(
	id_pedido bigint (10) auto_increment,
    atendente varchar(20),
    delivery boolean not null,
    tipo varchar (15),
    primary key(id_pedido)
);

insert into
