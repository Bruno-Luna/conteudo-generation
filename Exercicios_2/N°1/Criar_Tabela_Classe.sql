use db_generation_game_online;


create table tb_classe(
	id bigint auto_increment,
    localidade varchar(50),
    nivel int(3),
    elemento varchar(20),
    primary key(id)
);

select * from tb_classe;

INSERT INTO tb_classe (localidade, nivel, elemento) VALUES ("Japão", 4, "Terra");
INSERT INTO tb_classe (localidade, nivel, elemento) VALUES ("Brasil", 5, "Água");
INSERT INTO tb_classe (localidade, nivel, elemento) VALUES ("Alemanha", 3, "Fogo");
INSERT INTO tb_classe (localidade, nivel, elemento) VALUES ("Itália", 2, "Ar");
INSERT INTO tb_classe (localidade, nivel, elemento) VALUES ("México", 1, "Luz");



