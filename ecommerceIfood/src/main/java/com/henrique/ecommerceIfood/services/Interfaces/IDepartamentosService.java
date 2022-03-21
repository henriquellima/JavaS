package com.henrique.ecommerceIfood.services.Interfaces;

import com.henrique.ecommerceIfood.models.Departamento;
import com.henrique.ecommerceIfood.models.Pedido;

import java.util.List;
import java.util.Optional;

public interface IDepartamentosService {

    public Optional<Departamento> findByID(Integer id);

    public List<Departamento> findAll();

    public Departamento save(Departamento departamento);

}
