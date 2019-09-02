package burak.SpringSecurityWithDatabase.service;

import burak.SpringSecurityWithDatabase.entity.Users;
import burak.SpringSecurityWithDatabase.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    UserService userService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void findAll() {

        Users user1 = new Users();
        user1.setId(1L);
        Users user2 = new Users();
        user2.setId(2L);

        List<Users> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        List<Users> usersList = userRepository.findAll();

        verify(userRepository,times(1)).findAll();
        assertEquals(users,usersList);

    }

    @Test
    public void save() {

        Users user1 = new Users();
        user1.setId(1L);
        Users user2 = new Users();
        user2.setId(2L);

        List<Users> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Users savingUser = new Users();
        savingUser.setId(3L);

        when(userRepository.save(savingUser)).thenReturn(savingUser);

        Users savedUser = userRepository.save(savingUser);

        verify(userRepository,times(1)).save(savingUser);
        assertEquals(savingUser,savedUser);

    }

}