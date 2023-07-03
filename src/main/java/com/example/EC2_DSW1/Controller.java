package com.example.EC2_DSW1;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path="/")
public class Controller {

    @GetMapping(path="/")
    public String home() {
        return "LN90161994 - Luis Carmen Blas";
    }

    @GetMapping(path="/idat/codigo")
    public String codigo() {
        return "LN90161994";
    }

    @GetMapping(path="/idat/nombre-completo")
    public String nombrecompletoString() {
        return "Luis Carmen Blas";
    }

}