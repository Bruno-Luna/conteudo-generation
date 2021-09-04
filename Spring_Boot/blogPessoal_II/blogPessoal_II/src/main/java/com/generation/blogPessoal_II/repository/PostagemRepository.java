package com.generation.blogPessoal_II.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogPessoal_II.model.PostagemModel;

@Repository
public interface PostagemRepository  extends JpaRepository<PostagemModel, Long>{

}
