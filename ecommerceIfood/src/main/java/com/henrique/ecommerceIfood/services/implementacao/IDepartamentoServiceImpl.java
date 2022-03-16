package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.DepartamentoDAO;
import com.henrique.ecommerceIfood.models.Departamento;
import com.henrique.ecommerceIfood.models.Pedido;
import com.henrique.ecommerceIfood.services.Interfaces.IDepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class IDepartamentoServiceImpl implements IDepartamentosService {

    @Autowired
    DepartamentoDAO departamentoDAO;


    @Override
    public Optional<Departamento> getByID(Integer id) {
        return departamentoDAO.findById(id);
    }

    @Override
    public List<Departamento> getAll() {
        return (List<Departamento>) departamentoDAO.findAll();
    }

    @Override
    public Departamento save(Departamento departamento) {
        return departamentoDAO.save(departamento);
    }
}
