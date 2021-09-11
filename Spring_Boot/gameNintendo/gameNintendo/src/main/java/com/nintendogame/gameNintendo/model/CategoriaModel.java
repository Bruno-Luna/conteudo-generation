package com.nintendogame.gameNintendo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
public class CategoriaModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idCategoria;
	
	@NotBlank
	public String nomeCategoria;
	
	@NotBlank
	public String descricao;
	
	@OneToMany(mappedBy = "origin", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"origin"})
	private List<ProdutoModel> meusProdutos = new ArrayList<>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoModel> getMeusProdutos() {
		return meusProdutos;
	}

	public void setMeusProdutos(List<ProdutoModel> meusProdutos) {
		this.meusProdutos = meusProdutos;
	}
	
	}
