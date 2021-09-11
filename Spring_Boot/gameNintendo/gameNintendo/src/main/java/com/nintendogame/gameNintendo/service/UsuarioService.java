package com.nintendogame.gameNintendo.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nintendogame.gameNintendo.model.UsuarioModel;
import com.nintendogame.gameNintendo.model.utilities.UsuarioLogin;
import com.nintendogame.gameNintendo.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Object> cadastrarUsuario(UsuarioModel novoUsuario){
		return repository.findByEmail(novoUsuario.getEmail()).map(usuarioExistente ->{
			return Optional.empty();
		}).orElseGet(() ->{
			BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
			String result = enconder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(result);
			return Optional.ofNullable(repository.save(novoUsuario));
		});
	}
	
	public Optional<?> autenticador (UsuarioLogin usuarioAutenticar){
		return repository.findByEmail(usuarioAutenticar.getEmail()).map(usuarioExistente ->{
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();	
		
			if(enconder.matches(usuarioAutenticar.getSenha(), usuarioExistente.getSenha())) {
				String estruturaBasic = usuarioAutenticar.getEmail() + ":" + usuarioAutenticar.getSenha();
				byte[] autorizacaoBase64 = Base64.encodeBase64(estruturaBasic.getBytes(Charset.forName("US-ASCII")));
				String autorizacaoHeader = "Basic " + new String (autorizacaoBase64);
				
				usuarioAutenticar.setToken(autorizacaoHeader);
				usuarioAutenticar.setId(usuarioExistente.getIdUsuario());
				usuarioAutenticar.setNome(usuarioExistente.getNome());
				usuarioAutenticar.setSenha(usuarioExistente.getSenha());
				return Optional.ofNullable(usuarioAutenticar);

			} else {
				return Optional.empty(); // Senha errada
			}
		}).orElseGet(() -> {
			return Optional.empty(); // Email não existe	
		});
	}
}
