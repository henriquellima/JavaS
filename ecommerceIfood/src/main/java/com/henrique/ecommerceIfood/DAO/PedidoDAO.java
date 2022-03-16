package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.DTO.FaturamentoMes;
import com.henrique.ecommerceIfood.models.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

    @Query("SELECT new com.henrique.ecommerceIfood.DTO.FaturamentoMes( month(pedido.data) , sum(pedido.valor_total) , count(pedido) ) " +
            " FROM " +
            " Pedido as pedido " +
            " WHERE year(pedido.data) = :ano" +
            " GROUP BY month(pedido.data) ")
    public List<FaturamentoMes> getFaturamentoMes(int ano);
}
