package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.ProdutoDAO;
import com.henrique.ecommerceIfood.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping("/getAll")
    public List<Produto> getAll() {
        List<Produto> produtosList;
        produtosList = (List<Produto>) produtoDAO.findAll();
        return produtosList;
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Produto> getById(@PathVariable("id") Integer id){
        return produtoDAO.findById(id);
    }


    @PostMapping(
            path = ("/cadastrar"),
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Produto create(@RequestBody final Produto produto){
        produtoDAO.save(produto);
        return produto;
    }
}
