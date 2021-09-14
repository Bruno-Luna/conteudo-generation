package com.generation.blogPessoal_II.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


/**
 * Classe utilizada como Entidade no Banco de dados para Postagem, a mesma
 * possui atributos que serão colunas no banco com titulo: titulo e descricao.
 * 
 * @author Bruno Luna
 * @since 1.0
 */

@Entity
@Table(name = "postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostagem;
	
	@NotNull
	@Size(min =5, max = 70)
	private String titulo;
	
	@NotNull
	@Size(min =10, max = 700)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name = "criador_id")
	@JsonIgnoreProperties({"minhasPostagens"})
	private UsuarioModel criador;
	
	@ManyToOne
	@JoinColumn(name = "tema_id")
	@JsonIgnoreProperties({"postagens"})
	private TemaModel temaRelacionado;
	
	public Long getIdPostagem() {
		return idPostagem;
	}
	
	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public UsuarioModel getCriador() {
		return criador;
	}

	public void setCriador(UsuarioModel criador) {
		this.criador = criador;
	}

	public TemaModel getTemaRelacionado() {
		return temaRelacionado;
	}

	public void setTemaRelacionado(TemaModel temaRelacionado) {
		this.temaRelacionado = temaRelacionado;
	};
	
}
