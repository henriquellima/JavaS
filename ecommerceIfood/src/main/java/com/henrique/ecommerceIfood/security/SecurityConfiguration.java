package com.henrique.ecommerceIfood.security;

import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.filter.CustomAuthenticationFilter;
import com.henrique.ecommerceIfood.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers( Project.BASE_URL + "/usuarios/**").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers(Project.BASE_URL + "/produtos/editar/**", Project.BASE_URL + "/produtos/cadastrar/**"). hasAnyRole("MANAGER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, Project.BASE_URL + "/departamentos/cadastrar"). hasAnyRole("MANAGER", "ADMIN");
        http.authorizeRequests().antMatchers(Project.BASE_URL + "/pedidos/manage").hasAnyRole("MANAGER", "ADMIN");
        http.authorizeRequests().antMatchers(Project.BASE_URL + "/usuario").hasRole("USER");
        http.authorizeRequests().antMatchers(Project.BASE_URL + "/**").authenticated();
        http.authorizeRequests().antMatchers(Project.BASE_URL + "/login").permitAll();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class); // this filter, for this class
    }

    @Bean
    @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
