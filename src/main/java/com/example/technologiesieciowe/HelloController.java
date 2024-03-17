package com.example.technologiesieciowe;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello world!";
    }

    @GetMapping("/hello")
    public String helloSomeone(@RequestParam(required = false) String name,
                               @RequestParam String surname){
        if (name == null) { name = "";}
        return "Hello " +name +" "+surname+"!";

    }

    @GetMapping("/hello2/{name}")
    public String helloFormPath(@PathVariable String name){
        return "Hello " +name+"!";
}

    @GetMapping("/add")
    public int addNumbers(@RequestParam int number1,
                          @RequestParam int number2){
        return number1 + number2;
    }
}

//screeny klas i wywołania requestów z zad 1
//ss z postmana jako rozwiązanie zad 2
// w pdf