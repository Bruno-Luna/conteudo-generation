create database db_farmacia_do_bem;

use db_farmacia_do_bem;

create table tb_categoria(
id bigint primary key auto_increment,
higiene boolean,
medicamento boolean,
suplemento boolean
);

create table tb_produto(
id bigint primary key auto_increment,
nome varchar(30),
marca varchar(30),
preco decimal (6,2),
peso decimal (6,3),
validade date,
categoria_id bigint,
foreign key(categoria_id) references tb_categoria(id)
);

insert into  tb_categoria(higiene, medicamento, suplemento)
	values 
(true, false, false), 
(false, true, false),
(false, false, true),
(true, false, false),
(false, true, false);

insert into  tb_produto(nome,marca, preco, peso, validade, categoria_id)
	values 
("Sabonete", "P&G", 4.00, 0.67, '2022-12-22',1),
("Dipirona", "Pizer", 14.00, 0.125, '2024-08-22',2),
("Whey", "Biotec", 115.00, 2.50, '2023-07-12',3),
("Barbeador", "Gillete", 88.00, 0.350, '2030-04-02', 4),
("Lisador", "Medic", 15.00, 0.200, '2022-12-22',5);

select * from tb_produto where preco > 50.00;
select * from tb_produto where preco > 3.00 and preco < 60.00;
select * from tb_produto where nome like "%B%";


select * from tb_categoria
	inner join tb_produto on tb_produto.categoria_id = tb_categoria.id;

select * from tb_produto
	inner join tb_categoria on  tb_categoria.id = tb_produto.categoria_id
    where medicamento = true;