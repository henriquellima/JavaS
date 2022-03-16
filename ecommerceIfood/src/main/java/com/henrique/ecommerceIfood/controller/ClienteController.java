package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DTO.ClienteDTO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Cliente;
import com.henrique.ecommerceIfood.services.implementacao.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Project.BASE_URL + "/clientes")

public class ClienteController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    @Qualifier("padrao")
    private ClienteServiceImpl service;

    @GetMapping("/getall")
    public List<Cliente> getAll() {
        return (List<Cliente>) service.findAll();
    }

    @GetMapping("/getallcustom")
    public List<ClienteDTO> getAllCustom() {
        return (List<ClienteDTO>) service.findAllCustom();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Cliente> getAll(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @GetMapping("/getbyidcustom/{id}")
    public Optional<ClienteDTO> getByIdCustom(@PathVariable("id") Integer id) {
        return service.findByIdCustom(id);
    }

    @PostMapping("/cadastrar")
    public Cliente post(@RequestBody final Cliente cliente) {
        cliente.setPassword(encoder.encode(cliente.getPassword()));
        service.save(cliente);
        return cliente;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {

        Optional<Cliente> cliente = service.findByEmail(loginForm.email);
        if (cliente.isEmpty() || !(encoder.matches(loginForm.password, cliente.get().getPassword()))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("OI");
    }


    //records
    private record LoginForm(String email, String password) {
    }
}






