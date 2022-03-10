package com.henrique.carrosApi.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carros")
public class CarsController {

    @GetMapping()
    public String get(){
        return "API dos carros";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha){
        if(senha.equals("123")){
            return "ok   /// " + email;
        }
        else{
            return "senha errada";
        }
    }

}
