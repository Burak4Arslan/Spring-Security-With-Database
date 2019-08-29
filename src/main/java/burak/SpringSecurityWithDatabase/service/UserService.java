package burak.SpringSecurityWithDatabase.service;


import burak.SpringSecurityWithDatabase.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();
    Users save(Users user);
}
