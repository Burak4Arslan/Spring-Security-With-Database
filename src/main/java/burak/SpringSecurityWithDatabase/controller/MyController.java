package burak.SpringSecurityWithDatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String home() {
        return "Merhaba";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Helloo";
    }

}
