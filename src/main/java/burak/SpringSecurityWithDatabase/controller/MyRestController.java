package burak.SpringSecurityWithDatabase.controller;

import burak.SpringSecurityWithDatabase.entity.Users;
import burak.SpringSecurityWithDatabase.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

}
