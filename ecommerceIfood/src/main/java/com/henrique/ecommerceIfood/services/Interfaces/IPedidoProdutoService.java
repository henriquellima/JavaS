package com.henrique.ecommerceIfood.services.Interfaces;

import com.henrique.ecommerceIfood.models.PedidoProduto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface IPedidoProdutoService {
    public PedidoProduto findAll();
    public Optional<PedidoProduto> findByID(Integer id);
    public PedidoProduto save(PedidoProduto pedidoProduto);
}
