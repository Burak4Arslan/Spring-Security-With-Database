package burak.SpringSecurityWithDatabase.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String home() {
        return "Merhaba";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured")
    public String secured() {
        return "Helloo";
    }

}
