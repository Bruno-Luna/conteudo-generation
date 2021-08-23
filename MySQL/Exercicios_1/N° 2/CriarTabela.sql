use db_ecommerce;
-- usará DB acima referenciado

create table tb_produtos(
	serie bigint(5) auto_increment,
	nome varchar (30) not null,
    cor varchar (15),
    peso double (5,2) not null,
    marca varchar (15) not null, 
	setor varchar(30) not null,
    -- criação da tabela, com seus atributos, valores e definindo que ela será a chave principal
    primary key(serie)
);

select * from tb_produtos;
