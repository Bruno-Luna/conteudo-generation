select * from tb_classe
	inner join tb_personagem on tb_classe.id = tb_personagem.classe_id
where classe like "%fogo%";