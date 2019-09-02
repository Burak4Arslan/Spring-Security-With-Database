package burak.SpringSecurityWithDatabase.controller;

import burak.SpringSecurityWithDatabase.entity.Users;
import burak.SpringSecurityWithDatabase.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class UsersRestController {

    private final UserService userService;

    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public Users saveUser(@RequestBody Users user) {

        List<Users> myUsers = userService.findAll();

        for(Users a : myUsers) {
            if(a.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
        return userService.save(user);
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestBody String username) {

        Users userToDelete = userService.findByUsername(username);
        if(userToDelete==null) {
            return "Username Not Found";
        } else {
            userService.deleteUser(userToDelete.getUsername());
            return "OK";
        }

    }

}