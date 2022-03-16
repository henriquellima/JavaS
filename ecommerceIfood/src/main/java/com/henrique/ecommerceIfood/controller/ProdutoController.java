package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.ProdutoDAO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Produto;
import com.henrique.ecommerceIfood.services.implementacao.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Project.BASE_URL + "/produtos")
public class ProdutoController {

    @Autowired
    @Qualifier("padrao")
    private ProdutoServiceImpl service;

    @GetMapping("/getAll")
    public List<Produto> getAll() {
        List<Produto> produtosList;
        produtosList = (List<Produto>) service.findAll();
        return produtosList;
    }


    @GetMapping("/getbyid/{id}")
    public Optional<Produto> getById(@PathVariable("id") Integer id){
        return service.findByID(id);
    }


    @PostMapping(
            path = ("/cadastrar"),
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Produto create(@RequestBody final Produto produto){
        service.save(produto);
        return produto;
    }
}
