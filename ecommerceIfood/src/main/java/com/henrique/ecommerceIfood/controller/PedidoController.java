package com.henrique.ecommerceIfood.controller;

import com.henrique.ecommerceIfood.DAO.PedidoDAO;
import com.henrique.ecommerceIfood.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidoController {

    @Autowired
    private PedidoDAO pedidoDAO;

    @GetMapping("/getall")
    public List<Pedido> getAll(){
        return (List<Pedido>) pedidoDAO.findAll();

    }

    @GetMapping("/getbyid/{id}")
    public Optional<Pedido> getById(@PathVariable("id") Integer id){
        return pedidoDAO.findById(id);
    }

    @PostMapping(
            path = ("/cadastrar"),
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Pedido post(@RequestBody final Pedido pedido){
        pedidoDAO.save(pedido);
        return pedido;
    }

}
