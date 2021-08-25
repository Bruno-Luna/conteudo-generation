package com.generation.blogPessoal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogPessoal.modelos.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long> {

}
