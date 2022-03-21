package com.henrique.ecommerceIfood.controller;


import com.henrique.ecommerceIfood.DTO.FormForLoginDTO;
import com.henrique.ecommerceIfood.DTO.FormPermissaoDTO;
import com.henrique.ecommerceIfood.configuracoes.Project;
import com.henrique.ecommerceIfood.models.Usuario;
import com.henrique.ecommerceIfood.services.implementacao.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Project.BASE_URL + "/usuario")

public class UsuarioController {

    @Autowired
    UsuarioServiceImpl service;

    @GetMapping("/getall")
    public List<Usuario> findall(){
        return service.findAll();
    }

 //   @PostMapping("/login")
 //   public ResponseEntity<Token> logar(@RequestBody() final FormForLoginDTO form) {
  //      return service.logar(form);
  //  }

    @PostMapping("/cadastrar")
    public Usuario logar(@RequestBody() final Usuario novoUsuario) {
        return service.cadastrar(novoUsuario);
    }

    @PutMapping("/addpermissao")
    public ResponseEntity<Usuario> addPermissao(@RequestBody FormPermissaoDTO formPermissao){
        return service.addPermissao(formPermissao.getUsuarioEmail(), formPermissao.getPermissaoNome());
    }

}
