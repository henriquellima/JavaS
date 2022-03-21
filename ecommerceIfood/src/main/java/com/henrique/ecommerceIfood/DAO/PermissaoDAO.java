package com.henrique.ecommerceIfood.DAO;

import com.henrique.ecommerceIfood.models.Permissao;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface PermissaoDAO extends CrudRepository<Permissao, Integer> {

    public Optional<Permissao> findByNome(String permissaoName);
}
