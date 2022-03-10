package com.FirstSpring.FirstSpring.Controllers;


import com.FirstSpring.FirstSpring.models.Chefe;
import com.FirstSpring.FirstSpring.models.Funcionario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Word";
    }

    @GetMapping("/object")
    public Chefe Funcionario() {

        Chefe chefe = new Chefe("Henrique", 1034, 6125, 250, 10);

        return chefe;
    }

}
