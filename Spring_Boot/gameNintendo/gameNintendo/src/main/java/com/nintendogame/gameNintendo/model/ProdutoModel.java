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
public class ProdutoModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String preco;
	
	@NotBlank
	private String fabricante;
}
