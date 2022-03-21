package com.henrique.ecommerceIfood.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.ecommerceIfood.DTO.FormForLoginDTO;
import com.henrique.ecommerceIfood.Exeptions.AuthExeption;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Usuario;
import com.henrique.ecommerceIfood.response.ErrorMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static com.henrique.ecommerceIfood.EcommerceIfoodApplication.getAlgorithm;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final int MILI_SECS = 1;
    public static final int SECS = MILI_SECS*1000;
    public static final int MINUTES = SECS*60;
    public static final int HOURS = MINUTES*60;

    public static final String HEADER_ATRIBUTO = "Authorization";
    public static final String ATRIBUTO_PREFIXO = "Bearer ";

    public static final String ISSUER = "Henrique";
    public static final String TOKEN_SENHA = "ULTRASECRETAPRANAOROUPAMEUDADOS=(";
    private final AuthenticationManager authenticationManager;


    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.setFilterProcessesUrl(Project.BASE_URL + "/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            throw new AuthExeption("Falha ao autenticar o usuario \n" + e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
    User usuario = (User) authentication.getPrincipal();

        Algorithm algorithm = getAlgorithm(TOKEN_SENHA);
        String access_token = JWT.create()
                .withSubject(usuario.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 10*MINUTES))
                .withIssuer(ISSUER)
                .withClaim("roles", usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(usuario.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 20*MINUTES))
                .withIssuer(ISSUER)
                .sign(algorithm);

        //response.setHeader("access_token", access_token);
        //response.setHeader("refresh_token", refresh_token);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", ATRIBUTO_PREFIXO + access_token);
        tokens.put("refresh_token", ATRIBUTO_PREFIXO + refresh_token);

        response.setContentType(APPLICATION_JSON_VALUE);

           String responseObject = new ObjectMapper().writeValueAsString(tokens); // 82 e 83 é a mesma coisa que  new ObjectMapper().writeValue(response.getOutputStream(), tokens);
           response.getWriter().write(responseObject);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ErrorMessage errorMessage = new ErrorMessage(401, new Date(), "Login ou senha invalido!", request.getServletPath());
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(401);
        new ObjectMapper().writeValue(response.getOutputStream(), errorMessage);
    }
}
