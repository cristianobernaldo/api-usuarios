package com.teste.crud_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import com.teste.crud_api.model.Produto;
import com.teste.crud_api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public Produto salvar(@Valid @RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
public Produto atualizar(@PathVariable Long id,
                         @Valid @RequestBody Produto produto) {
    return service.atualizar(id, produto);
}

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}