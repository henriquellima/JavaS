package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.DepartamentoDAO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Departamento;
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
    private DepartamentoDAO departamentoDAO;

    @GetMapping("/getall")
    public List<Departamento> getAll() {
        return (List<Departamento>) departamentoDAO.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Departamento> getByID(@PathVariable("id") Integer id) {
        return departamentoDAO.findById(id);
    }

    @PostMapping(
            path = ("/cadastrar"),
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Departamento post(@RequestBody final Departamento departamento){
        departamentoDAO.save(departamento);
        return departamento;
    }
}
