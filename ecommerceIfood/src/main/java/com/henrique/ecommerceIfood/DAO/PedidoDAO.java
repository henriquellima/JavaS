package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.models.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

}
