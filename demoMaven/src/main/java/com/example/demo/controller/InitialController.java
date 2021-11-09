package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class InitialController {



    @GetMapping("/{name}")
    public String saludoConNombre(@PathVariable(name="name")String name) {
        return String.format("Hello %s !",name);
        
    }
    



}
