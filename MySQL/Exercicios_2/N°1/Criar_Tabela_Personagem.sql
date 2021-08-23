create table tb_personagem(
	id bigint auto_increment,
    nome varchar(30) not null,
    forca int(9) not null,
    defesa int(9) not null,
    agilidade int(9),
    peso double (3,2) not null,
    classe_id bigint not null,
    
    primary key(id),
    foreign key(classe_id) references tb_classe(id)
);
select * from tb_personagem;

	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Lavitz", 3580, 3000, 1800, 9.37, 1);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Noa", 2580, 3300, 1200, 4.37, 2);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Saga", 1580, 3400, 1300, 5.37, 3);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Vanh", 2280, 2500, 1400, 6.37, 4);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Lupin", 3280, 2400, 1500, 7.37, 5);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Merlin", 1010, 2200, 1800, 5.37, 2);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Franz", 1990, 1300, 1000, 6.37, 3);
	insert into tb_personagem (nome, forca, defesa, agilidade, peso, classe_id) values ("Lavitz", 3580, 3000, 1800, 9.27, 4);

