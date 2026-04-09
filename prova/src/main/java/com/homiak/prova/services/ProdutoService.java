package com.homiak.prova.services;

import com.homiak.prova.models.Produto;
import com.homiak.prova.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Produto atualizar(Produto produto){
        Produto novoProduto = buscarPorId(produto.getId());
        novoProduto.setNome(produto.getNome());
        novoProduto.setPreco(produto.getPreco());
        novoProduto.setDescricao(produto.getDescricao());
        novoProduto.setStatus(produto.getStatus());
        return repository.save(novoProduto);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
