package com.example.technologiesieciowe;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.*;

/**
 * The type Hello controller.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * Hello world string.
     *
     * @return the string
     */
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello world!";
    }

    /**
     * Hello someone string.
     *
     * @param name    the name
     * @param surname the surname
     * @return the string
     */
    @GetMapping("/hello")
    public String helloSomeone(@RequestParam(required = false) String name,
                               @RequestParam String surname){
        if (name == null) { name = "";}
        return "Hello " +name +" "+surname+"!";

    }

    /**
     * Hello form path string.
     *
     * @param name the name
     * @return the string
     */
    @GetMapping("/hello2/{name}")
    public String helloFormPath(@PathVariable String name){
        return "Hello " +name+"!";
}

    /**
     * Add numbers int.
     *
     * @param number1 the number 1
     * @param number2 the number 2
     * @return the int
     */
    @GetMapping("/add")
    public int addNumbers(@RequestParam int number1,
                          @RequestParam int number2){
        return number1 + number2;
    }
}

//screeny klas i wywołania requestów z zad 1
//ss z postmana jako rozwiązanie zad 2
// w pdf