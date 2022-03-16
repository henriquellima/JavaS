package com.henrique.ecommerceIfood.services.Interfaces;

import com.henrique.ecommerceIfood.DTO.ClienteDTO;
import com.henrique.ecommerceIfood.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClientesService {
    public Optional<Cliente> findById(Integer id);

    public Optional<ClienteDTO> findByIdCustom(Integer id);

    public List<Cliente> findAll();

    public List<ClienteDTO> findAllCustom();

    public Cliente save(Cliente novoCliente);

    Optional<Cliente> findByEmail(String email);
}
