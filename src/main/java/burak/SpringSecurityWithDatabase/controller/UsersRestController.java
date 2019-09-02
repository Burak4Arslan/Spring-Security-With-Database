package burak.SpringSecurityWithDatabase.controller;

import burak.SpringSecurityWithDatabase.entity.Role;
import burak.SpringSecurityWithDatabase.entity.Users;
import burak.SpringSecurityWithDatabase.service.RoleService;
import burak.SpringSecurityWithDatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Transactional
public class UsersRestController {

    private final UserService userService;

    private RoleService roleService;

    @Autowired
    public UsersRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/user")
    public Users getUsers(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/users")
    public Users saveUser(@RequestBody Users user) {

        List<Users> myUsers = userService.findAll();

        for(Users a : myUsers) {
            if(a.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
        Role userRole = roleService.findByRole("USER");
        Set<Role> newRoleSet = new HashSet<>();
        newRoleSet.add(userRole);
        user.setRoleSet(newRoleSet);

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
