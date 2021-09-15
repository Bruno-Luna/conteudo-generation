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
 * Classe utilizada como Entidade no Banco de dados para Usuario, a mesma possui
 * atributos que serão colunas no banco com titulo : nome, email e senha.
 * 
 * @author Bruno Luna
 * @since 1.0
 */

@Entity
@Table (name = "usuario")
public class UsuarioModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotBlank(message = "O nome é Obrigatório")
	private String nome;
	
	@NotBlank(message = "O email é Obrigatório")
	private String email;
	
	@NotBlank(message = "A senha é Obrigatória")
	private String senha;
	
	@OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"criador"})
	private List<PostagemModel> minhasPostagens = new ArrayList<>();
	

	public UsuarioModel(Long idUsuario, String nome,  String email, String senha) {
		
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public UsuarioModel() { }

	public List<PostagemModel> getMinhasPostagens() {
		return minhasPostagens;
	}

	public void setMinhasPostagens(List<PostagemModel> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
