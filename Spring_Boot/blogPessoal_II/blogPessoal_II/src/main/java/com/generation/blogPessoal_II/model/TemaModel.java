package com.generation.blogPessoal_II.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe utilizada como Entidade no Banco de dados para Tema, a mesma possui
 * atributos que serão colunas no banco com titulo: tema.
 * 
 * @author Bruno Luna
 * @since 1.0
 */

@Entity
@Table(name = "tema")
public class TemaModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTema;
	
	@NotBlank
	private String tema;
	
	@OneToMany (mappedBy = "temaRelacionado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"temaRelacionado"})
	private List<PostagemModel> postagens = new ArrayList<>();

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
}
