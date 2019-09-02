package burak.SpringSecurityWithDatabase.controller;

import burak.SpringSecurityWithDatabase.entity.Users;
import burak.SpringSecurityWithDatabase.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UsersRestControllerTest {

    @Mock
    UserService userService;

    UsersRestController usersRestController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        usersRestController = new UsersRestController(userService);
    }

    @Test
    public void getUsers() {

        Users user1 = new Users();
        user1.setId(1L);
        Users user2 = new Users();
        user2.setId(2L);

        List<Users> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(userService.findAll()).thenReturn(users);

        List<Users> usersList = usersRestController.getUsers();

        verify(userService,times(1)).findAll();
        assertEquals(users,usersList);


    }

    @Test
    public void saveUser() {

        Users user1 = new Users();
        user1.setId(1L);
        Users user2 = new Users();
        user2.setId(2L);

        List<Users> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Users savingUser = new Users();
        savingUser.setId(3L);
        Users savingUserFail = new Users();
        savingUser.setId(3L);

        when(userService.save(savingUser)).thenReturn(savingUser);
        when(userService.save(savingUserFail)).thenReturn(null);

        Users savedUser = usersRestController.saveUser(savingUser);
        Users savedUserFail = usersRestController.saveUser(savingUserFail);

        verify(userService,times(1)).save(savingUser);
        verify(userService,times(2)).findAll();
        assertEquals(savingUser,savedUser);
        assertEquals(null,savedUserFail);


    }
}