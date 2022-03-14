package com.henrique.ecommerceIfood.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.ecommerceIfood.data.DetalhesCliente;
import com.henrique.ecommerceIfood.models.Cliente;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTFilterGenerator extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "ULTRASECRETAPRANAOROUPAMEUDADOS=(";
    public final AuthenticationManager authenticationManager;

    public JWTFilterGenerator(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Cliente cliente = new ObjectMapper()
                    .readValue(request.getInputStream(), Cliente.class); //cria uma classe cliente

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    cliente.getEmail(),
                    cliente.getPassword(),
                    new ArrayList<>() // permissoes
            ));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao atenticar usuario", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        DetalhesCliente detalhesCliente = (DetalhesCliente) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(detalhesCliente.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC256(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
