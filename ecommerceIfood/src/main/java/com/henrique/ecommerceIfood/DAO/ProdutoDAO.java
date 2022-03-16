package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.models.Produto;
import com.henrique.ecommerceIfood.models.Departamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {

    // aqui virão minhas consultas costumizadas
    @Query("SELECT new "
            + "com.henrique.ecommerceIfood.models.Produto(produto.id,"
            + "                                          produto.nome,"
            + "                                          produto.descricao,"
            + "                                          produto.preco,"
            + "                                          produto.qtdEstoque,"
            + "                                          produto.linkFoto,"
            + "                                          departamento.id,"
            + "                                          departamento.nome,"
            + "                                          departamento.andar) "
            + "FROM "
            + "Produto as produto INNER JOIN Departamento as departamento ON "
            + "produto.departamento.id = departamento.id")
    public List<Produto> buscarProdutos();
}