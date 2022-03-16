package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.ClienteDAO;
import com.henrique.ecommerceIfood.DTO.ClienteDTO;
import com.henrique.ecommerceIfood.models.Cliente;
import com.henrique.ecommerceIfood.services.Interfaces.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
@Qualifier("padrao")
public class ClienteServiceImpl implements IClientesService {

    @Autowired
    private ClienteDAO dao;

    @Override
    public Optional<ClienteDTO> findByIdCustom(Integer id) {
        return dao.findByIdCustom(id);
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) dao.findAll();
    }

    @Override
    public List<ClienteDTO> findAllCustom() {
        return (List<ClienteDTO>) dao.findAllCustom();
    }

    @Override
    public Cliente save(Cliente novoCliente) {
        return dao.save(novoCliente);
    }
}
