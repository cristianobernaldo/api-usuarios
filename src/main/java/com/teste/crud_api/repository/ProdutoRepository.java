package com.teste.crud_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teste.crud_api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}