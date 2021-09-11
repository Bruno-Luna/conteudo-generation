package com.nintendogame.gameNintendo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


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
	
	@ManyToOne
	@JoinColumn(name = "origin_id")
	@JsonIgnoreProperties({"meusProdutos"})
	private CategoriaModel origin;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public CategoriaModel getOrigin() {
		return origin;
	}

	public void setOrigin(CategoriaModel origin) {
		this.origin = origin;
	}
	
	
}
