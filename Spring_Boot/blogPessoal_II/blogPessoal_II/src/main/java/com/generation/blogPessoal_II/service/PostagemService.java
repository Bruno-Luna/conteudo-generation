package com.generation.blogPessoal_II.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.blogPessoal_II.model.PostagemModel;
import com.generation.blogPessoal_II.model.TemaModel;
import com.generation.blogPessoal_II.model.UsuarioModel;
import com.generation.blogPessoal_II.repository.PostagemRepository;
import com.generation.blogPessoal_II.repository.TemaRepository;
import com.generation.blogPessoal_II.repository.UsuarioRepository;

@Service
public class PostagemService {
	
	@Autowired 
	private PostagemRepository repositorioP;
	@Autowired 
	private UsuarioRepository repositorioU;
	@Autowired 
	private TemaRepository repositorioT;
	
	/**
	 * Método utilizado para alterar uma postagem que retorna um Optional com
	 * Postagem caso corretoou um Optional.empty() caso id da Postagem não exista.
	 * 
	 * @param postagemParaAlterar do tipo Postagem
	 * @return Optional com Postagem alterada
	 * @since 2.0
	 * @author Bruno Luna
	 */
	
	public Optional<?> atualizarPostagem(PostagemModel postagemParaAlterar) {
		return repositorioP.findById(postagemParaAlterar.getIdPostagem()).map(postagemExistente -> {
			Optional<UsuarioModel> optionalUsuario = repositorioU.findById(postagemParaAlterar.getCriador().getIdUsuario());
			Optional<TemaModel> optionalTema = repositorioT.findById(postagemParaAlterar.getTemaRelacionado().getIdTema());
			if (optionalUsuario.isPresent() && optionalTema.isPresent()) {
				postagemExistente.setTitulo(postagemParaAlterar.getTitulo());
				postagemExistente.setTexto(postagemParaAlterar.getTexto());
				return Optional.ofNullable(repositorioP.save(postagemExistente));
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	
	/**
	 * Método usado no cadastro de uma nova postagem dentro do banco, validando se o
	 * usuario criador é existente. O id do usuario criador e o id do tema devem ser
	 * repassados dentro do objeto postagem para que a devida criação seja efetuada.
	 * Caso o id do usuario não for passado ou não existir no banco, há retorno de
	 * um Optional.empty()
	 * 
	 * @param novaPostagem do tipo Postagem
	 * @return Optional com Postagem
	 * @since 1.5
	 * @author Bruno Luna
	 */
	
	public Optional<?> cadastrarPostagem(PostagemModel novaPostagem) {
		Optional<TemaModel> objetoExistente = repositorioT.findById(novaPostagem.getTemaRelacionado().getIdTema());
		return repositorioU.findById(novaPostagem.getCriador().getIdUsuario()).map(usuarioExistente -> {
			if (objetoExistente.isPresent()) {
				novaPostagem.setCriador(usuarioExistente);
				novaPostagem.setTemaRelacionado(objetoExistente.get());
				return Optional.ofNullable(repositorioP.save(novaPostagem));
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
