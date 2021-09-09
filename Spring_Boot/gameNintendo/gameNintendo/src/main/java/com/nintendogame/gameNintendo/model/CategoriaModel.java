package com.nintendogame.gameNintendo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CategoriaModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idCategoria;
	
	@NotBlank
	public String nomeCategoria;
	
	@NotBlank
	public String descricao;
}
