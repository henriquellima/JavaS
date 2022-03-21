package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.PedidoProdutoDAO;
import com.henrique.ecommerceIfood.models.PedidoProduto;
import com.henrique.ecommerceIfood.services.Interfaces.IPedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Optional;

@Component
@Primary
@Qualifier("padrao")
public class PedidoProdutoServiceImpl implements IPedidoProdutoService {

    @Autowired
    PedidoProdutoDAO dao;

    @Override
    public PedidoProduto findAll() {
        return (PedidoProduto) dao.findAll();
    }

    @Override
    public Optional<PedidoProduto> findByID(Integer id) {
        return dao.findById(id);
    }

    @Override
    public PedidoProduto save(PedidoProduto pedidoProduto) {
        return dao.save(pedidoProduto);
    }
}
