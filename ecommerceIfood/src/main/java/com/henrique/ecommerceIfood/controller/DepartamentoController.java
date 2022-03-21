package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.DepartamentoDAO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Departamento;
import com.henrique.ecommerceIfood.services.implementacao.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Project.BASE_URL + "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoServiceImpl service;

    @GetMapping("/getall")
    public List<Departamento> getAll() {
        return (List<Departamento>) service.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Departamento> getByID(@PathVariable("id") Integer id) {
        return service.findByID(id);
    }

    @PostMapping( path = ("/cadastrar") )
    public Departamento post(@RequestBody final Departamento departamento){
        service.save(departamento);
        return departamento;
    }
}
