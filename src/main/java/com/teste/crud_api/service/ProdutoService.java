package com.teste.crud_api.service;

import com.teste.crud_api.model.Produto;
import com.teste.crud_api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {

    Produto produto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    produto.setNome(produtoAtualizado.getNome());
    produto.setPreco(produtoAtualizado.getPreco());

    return repository.save(produto);
}

    public Produto buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}