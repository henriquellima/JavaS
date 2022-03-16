package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.DTO.ClienteDTO;
import com.henrique.ecommerceIfood.models.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    Optional<Cliente> findByEmail(String email);

    @Query("SELECT new com.henrique.ecommerceIfood.DTO.ClienteDTO(" +
            "cliente.id, " +
            "cliente.nome, " +
            "cliente.cpf, " +
            "cliente.email, " +
            "cliente.telefone) " +
            "FROM Cliente as cliente " +
            "WHERE cliente.id = :id")
    public Optional<ClienteDTO> findByIdCustom(@Param("id") Integer id);

    @Query("SELECT new com.henrique.ecommerceIfood.DTO.ClienteDTO(" +
            "cliente.id, " +
            "cliente.nome, " +
            "cliente.cpf, " +
            "cliente.email, " +
            "cliente.telefone) " +
            "FROM Cliente as cliente")
    public List<ClienteDTO> findAllCustom();
}
