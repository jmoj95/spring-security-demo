package br.ufc.demos.springsecuritydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello, humans! There's absolutely NOTHING going on on our /private area!";
    }

    @GetMapping("/private")
    public String privateArea() {
        return "Hello, aliens, mutants, demons, failed experiments and all the weird stuff!";
    }

    @GetMapping("/admin")
    public String adminArea() {
        return "Hello, Mr. Admin. How is your business as CEO of Racism going?";
    }

}