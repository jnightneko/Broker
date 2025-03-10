package gt.edu.umes.broker.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class Test {

    @GetMapping("/test")
    public String helloWorld() {
        return "Hola Mundo!";
    }
}
