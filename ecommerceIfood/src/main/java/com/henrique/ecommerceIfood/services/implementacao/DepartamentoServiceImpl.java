package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.DepartamentoDAO;
import com.henrique.ecommerceIfood.models.Departamento;
import com.henrique.ecommerceIfood.services.Interfaces.IDepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Primary
@Qualifier("padrao")
public class DepartamentoServiceImpl implements IDepartamentosService {

    @Autowired
    DepartamentoDAO departamentoDAO;


    @Override
    public Optional<Departamento> findByID(Integer id) {
        return departamentoDAO.findById(id);
    }

    @Override
    public List<Departamento> findAll() {
        return (List<Departamento>) departamentoDAO.findAll();
    }

    @Override
    public Departamento save(Departamento departamento) {
        return departamentoDAO.save(departamento);
    }
}
