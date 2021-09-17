package com.generation.blogPessoal.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.blogPessoal.modelos.Usuario;
import com.generation.blogPessoal.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicos {
	private @Autowired UsuarioRepositorio repositorio;
	
	public Optional<Usuario> cadastrarUsuario(Usuario novoUsuario){
		return repositorio.findByEmail(novoUsuario);
	}
}
