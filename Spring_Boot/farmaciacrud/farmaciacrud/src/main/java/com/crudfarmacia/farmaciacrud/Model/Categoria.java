package com.crudfarmacia.farmaciacrud.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotBlank
	@Size(min = 5, max = 20)
	private String categoria;
	
	@NotBlank
	private Long codigoBarra;

	@ManyToOne 
	@JoinColumn(name = "produto_id")
	@JsonIgnoreProperties({"classeproduto"})
	private Produto classecategoria;
	

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(Long codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	
}
