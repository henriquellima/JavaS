package com.henrique.ecommerceIfood.services.Interfaces;

import com.henrique.ecommerceIfood.DTO.FormForLoginDTO;
import com.henrique.ecommerceIfood.models.Usuario;
//import com.henrique.ecommerceIfood.security.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public Usuario cadastrar(Usuario novoUsuario);

   // public ResponseEntity<Token> logar(FormForLoginDTO formLogin) throws AuthenticationException;

    public Optional<Usuario> findByEmail(String email);

    public Optional<Usuario> findByID(int id);

    public List<Usuario> findAll();

    public ResponseEntity<Usuario> addPermissao(String usuarioEmail, String permissaoName);

}
