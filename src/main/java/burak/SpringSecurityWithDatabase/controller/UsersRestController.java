package burak.SpringSecurityWithDatabase.controller;

import burak.SpringSecurityWithDatabase.entity.Role;
import burak.SpringSecurityWithDatabase.entity.Users;
import burak.SpringSecurityWithDatabase.service.RoleService;
import burak.SpringSecurityWithDatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/users")
    public String deleteUser(@RequestBody String username) {
        System.out.println(username);
        Users userToDelete = userService.findByUsername(username);
        if(userToDelete==null) {
            return "Username Not Found";
        } else {
            userService.deleteUser(userToDelete.getUsername());
            return "OK";
        }

    }

}
