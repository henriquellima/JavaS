package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {

    // aqui virão minhas consultas costumizadas

}
