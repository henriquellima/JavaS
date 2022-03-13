package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    Optional<Cliente> findByEmail(String email);
}
