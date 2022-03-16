package com.henrique.ecommerceIfood.services.Interfaces;


import com.henrique.ecommerceIfood.DAO.PedidoDAO;
import com.henrique.ecommerceIfood.DTO.FaturamentoMes;
import com.henrique.ecommerceIfood.models.Departamento;
import com.henrique.ecommerceIfood.models.Pedido;

import java.util.List;
import java.util.Optional;


public interface IPedidosService {

    public Pedido adicionarPedido(Pedido novoPedido);

    public List<FaturamentoMes> getFaturamentoMes(int ano);

    public boolean removerPedido(Integer id);

    public Optional<Pedido> findByID(Integer id);

    public List<Pedido> findAll();

    public Pedido save(Pedido pedido);

}
