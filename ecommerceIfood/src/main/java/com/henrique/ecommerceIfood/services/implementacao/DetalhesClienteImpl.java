package com.henrique.ecommerceIfood.services.implementacao;

import com.henrique.ecommerceIfood.DAO.ClienteDAO;
import com.henrique.ecommerceIfood.data.DetalhesCliente;
import com.henrique.ecommerceIfood.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
@Qualifier("padrao")
public class DetalhesClienteImpl implements UserDetailsService {

    @Autowired
    private ClienteDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> cliente = usuarioDAO.findByEmail(email);
        if(cliente.isEmpty()){
            throw new UsernameNotFoundException("Usuario [" + cliente + "] não encontrado");
        }

        return new DetalhesCliente(cliente);
    }
}
