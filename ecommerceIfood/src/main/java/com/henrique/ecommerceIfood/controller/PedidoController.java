package com.henrique.ecommerceIfood.controller;

import com.henrique.ecommerceIfood.DTO.FaturamentoMes;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Pedido;
import com.henrique.ecommerceIfood.services.Interfaces.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Project.BASE_URL + "/pedidos")
public class PedidoController {

    @Autowired
    @Qualifier("dia-a-dia")
    private IPedidosService service;

    @GetMapping("/getall")
    public List<Pedido> getAll() {
        return (List<Pedido>) service.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Pedido> getById(@PathVariable("id") Integer id) {
        return service.findByID(id);
    }

    @GetMapping("/getfaturamentomensal/{ano}")
    public List<FaturamentoMes> getFaturamentoMensal(@PathVariable("ano") int ano) {
        return service.getFaturamentoMes(ano);
    }

    @PostMapping(path = ("/cadastrar") )
    public Pedido post(@RequestBody final Pedido novoPedido) {
        return service.adicionarPedido(novoPedido);
    }

}
