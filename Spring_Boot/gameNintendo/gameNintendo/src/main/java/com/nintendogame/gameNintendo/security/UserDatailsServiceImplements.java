package com.nintendogame.gameNintendo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nintendogame.gameNintendo.model.UsuarioModel;
import com.nintendogame.gameNintendo.repository.UsuarioRepository;

@Service
public class UserDatailsServiceImplements  implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> objeOptional = repository.findByEmail(username);
		
		if(objeOptional.isPresent()) {
			return new UserDetailsImplements(objeOptional.get());
		}else {
			throw new UsernameNotFoundException(username + "Não existe");
		}
	}
}
