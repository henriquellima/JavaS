package com.henrique.ecommerceIfood.services.implementacao;


import com.henrique.ecommerceIfood.DAO.PedidoDAO;
import com.henrique.ecommerceIfood.DTO.FaturamentoMes;
import com.henrique.ecommerceIfood.models.Departamento;
import com.henrique.ecommerceIfood.models.Pedido;
import com.henrique.ecommerceIfood.models.PedidoProduto;
import com.henrique.ecommerceIfood.services.Interfaces.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
@Qualifier("dia-a-dia")
public class PedidosServiceImpl implements IPedidosService {

    @Autowired
    private PedidoDAO dao;

    @Override
    public Pedido adicionarPedido(Pedido novoPedido) {

        for(PedidoProduto item : novoPedido.getProdutosList()){
            item.setPedido(novoPedido);
        }
        return dao.save(novoPedido);
    }

    @Override
    public List<FaturamentoMes> getFaturamentoMes(int ano) {
        return dao.getFaturamentoMes(ano);
    }

    @Override
    public boolean removerPedido(Integer id) {
        try{
            dao.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Optional<Pedido> findByID(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Pedido> findAll() {
        return (List<Pedido>) dao.findAll();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return dao.save(pedido);
    }
}
