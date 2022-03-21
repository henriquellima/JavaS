package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.PermissaoDAO;
import com.henrique.ecommerceIfood.DAO.UsuarioDAO;
import com.henrique.ecommerceIfood.DTO.FormForLoginDTO;
import com.henrique.ecommerceIfood.Exeptions.AuthExeption;
import com.henrique.ecommerceIfood.Exeptions.ResourceNotFoundException;
import com.henrique.ecommerceIfood.models.Permissao;
import com.henrique.ecommerceIfood.models.Usuario;
//import com.henrique.ecommerceIfood.security.Token;
//import com.henrique.ecommerceIfood.security.TokenUtil;
import com.henrique.ecommerceIfood.services.Interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
@Primary
@Qualifier("padrao")
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService{

    @Autowired
    private UsuarioDAO dao;
    @Autowired
    private PermissaoDAO permissaoDAO;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Usuario cadastrar(Usuario novoUsuario) {
        novoUsuario.setSenha(encoder.encode(novoUsuario.getSenha()));

        return dao.save(novoUsuario);
    }

//    @Override
//    public ResponseEntity<Token> logar(FormForLoginDTO formLogin) {
//        Optional<Usuario> usuario = dao.findByEmail(formLogin.getEmail());
//
//        if(usuario.isEmpty() || !encoder.matches(formLogin.getSenha(), usuario.get().getSenha())){
//            throw new AuthExeption("Login ou Senha invalido");
//        }
//
//        Token token = new Token(TokenUtil.createToken(usuario.get()));
//        return ResponseEntity.ok(token);
//    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public Optional<Usuario> findByID(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) dao.findAll();
    }

    @Override
    public ResponseEntity<Usuario> addPermissao(String usuarioEmail, String permissaoName) {
        permissaoName = permissaoName.toUpperCase();
        System.out.println(permissaoName);
        Optional<Usuario> usuario = dao.findByEmail(usuarioEmail);
        Optional<Permissao> permissao = permissaoDAO.findByNome(permissaoName);

        if (usuario.isEmpty() || permissao.isEmpty()) {
            throw new ResourceNotFoundException("Usuario ID ou Permissão não encontrada.");
        }

        usuario.get().getPermissaoList().add(permissao.get());
        dao.save(usuario.get());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(usuario.get());

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOp = dao.findByEmail(email);
        System.out.println("passei por aqui");
        if (usuarioOp.isEmpty()) {
            throw new UsernameNotFoundException("Usuario/senha incorretos.");
        }
        Usuario usuario = usuarioOp.get();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getPermissaoList().forEach(permissao ->
        {
            authorities.add(new SimpleGrantedAuthority(permissao.getNome()));
        });

        return new User(usuario.getEmail(), usuario.getSenha(), authorities);
    }

}
