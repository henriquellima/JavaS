package com.henrique.ecommerceIfood.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.response.ErrorMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static com.henrique.ecommerceIfood.EcommerceIfoodApplication.getAlgorithm;
import static com.henrique.ecommerceIfood.filter.CustomAuthenticationFilter.ATRIBUTO_PREFIXO;
import static com.henrique.ecommerceIfood.filter.CustomAuthenticationFilter.TOKEN_SENHA;
import static java.util.Arrays.parallelSetAll;
import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals(Project.BASE_URL + "/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith(ATRIBUTO_PREFIXO)) {
            filterChain.doFilter(request, response);
            return;
        }
        ;

        try {
            String token = authorizationHeader.replace( ATRIBUTO_PREFIXO, "");

            Algorithm algorithm = getAlgorithm(TOKEN_SENHA);

            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT decodedJWT = verifier.verify((token));

            String email = decodedJWT.getSubject();
            String[] rolesString = decodedJWT.getClaim("roles").asArray(String.class);
            Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
            stream(rolesString).forEach(role -> roles.add(new SimpleGrantedAuthority(role)));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,null, roles);

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            filterChain.doFilter(request, response);
        } catch (Exception e) {

            ErrorMessage errorMessage = new ErrorMessage(401, new Date(), e.getMessage(), request.getServletPath());
            response.setContentType(APPLICATION_JSON_VALUE);
            response.setStatus(403);
            new ObjectMapper().writeValue(response.getOutputStream(), errorMessage);

        }
        filterChain.doFilter(request, response);

        ;
    }

}
