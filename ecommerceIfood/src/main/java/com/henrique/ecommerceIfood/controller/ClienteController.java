package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DAO.ClienteDAO;
import com.henrique.ecommerceIfood.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cliente")

public class ClienteController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ClienteDAO clienteDAO;

    @GetMapping("/getall")
    public List<Cliente> getAll() {
        return (List<Cliente>) clienteDAO.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Cliente> getAll(@PathVariable("id") Integer id) {
        return clienteDAO.findById(id);
    }

    @PostMapping("/cadastrar")
    public Cliente post(@RequestBody final Cliente cliente) {
        cliente.setPassword(encoder.encode(cliente.getPassword()));
        clienteDAO.save(cliente);
        return cliente;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm ) {

        Optional<Cliente> cliente = clienteDAO.findByEmail(loginForm.email);
        if (cliente.isEmpty() || !(encoder.matches(loginForm.password, cliente.get().getPassword()))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("tokenzinPáTí");
    }



    //records
    private record LoginForm(String email, String password) {
    }
}






