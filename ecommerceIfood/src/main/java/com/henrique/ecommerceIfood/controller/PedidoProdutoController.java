package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.PedidoProdutoDAO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.PedidoProduto;
import com.henrique.ecommerceIfood.services.implementacao.PedidoProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Project.BASE_URL + "/pedidoprodutos")
public class PedidoProdutoController {

    @Autowired
    @Qualifier("padrao")
    PedidoProdutoServiceImpl service;

    @GetMapping("/getall")
    public List<PedidoProduto> getAll(){
        return (List<PedidoProduto>) service.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<PedidoProduto> getbyid(@PathVariable("id") Integer id){
        return service.findByID(id);
    }

    @PostMapping("/cadastrar")
    public PedidoProduto post(@RequestBody final PedidoProduto pedidoProduto){
        service.save(pedidoProduto);
        return pedidoProduto;
    }
}
