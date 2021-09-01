package com.crudfarmacia.farmaciacrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudfarmacia.farmaciacrud.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
