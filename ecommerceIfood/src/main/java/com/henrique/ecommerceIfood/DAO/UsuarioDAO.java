package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.models.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    public Optional<Usuario> findByEmail(String email);


}
