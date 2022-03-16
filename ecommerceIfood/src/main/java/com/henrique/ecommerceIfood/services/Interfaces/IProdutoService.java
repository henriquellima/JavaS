package com.henrique.ecommerceIfood.services.Interfaces;

import com.henrique.ecommerceIfood.models.Produto;

import java.util.List;
import java.util.Optional;

public interface IProdutoService {

    public Optional<Produto> findByID(Integer id);

    public List<Produto> findAll();

    public Produto save(Produto produto);

}
