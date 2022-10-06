package com.turnosclinica.demoturnosclinica.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/login")
    public String home(){
        return "<h1>Bienvenidos</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>Bienvenido Usuario</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Bienvenido Administrador</h1>";
    }
}
