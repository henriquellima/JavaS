package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.ProdutoDAO;
import com.henrique.ecommerceIfood.models.Produto;
import com.henrique.ecommerceIfood.services.Interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Component
@Primary
@Qualifier("padrao")
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    ProdutoDAO dao;

    @Override
    public Optional<Produto> findByID(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Produto> findAll() {
        return dao.buscarProdutos();
    }

    @Override
    public Produto save(Produto produto) {
        return dao.save(produto);
    }
}
