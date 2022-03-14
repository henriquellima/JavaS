package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.PedidoProdutoDAO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.PedidoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Project.BASE_URL + "/pedidoProduto")
public class PedidoProdutoController {

    @Autowired
    PedidoProdutoDAO pedidoProdutoDAO;

    @GetMapping("/getall")
    public List<PedidoProduto> getAll(){
        return (List<PedidoProduto>) pedidoProdutoDAO.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<PedidoProduto> getbyid(@PathVariable("id") Integer id){
        return pedidoProdutoDAO.findById(id);
    }

    @PostMapping("/cadastrar")
    public PedidoProduto post(@RequestBody final PedidoProduto pedidoProduto){
        pedidoProdutoDAO.save(pedidoProduto);
        return pedidoProduto;
    }
}
