package burak.SpringSecurityWithDatabase.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UsersTest {

    Users myUser;
    Set<Role> roles;
    @Before
    public void setUp() throws Exception {

        myUser = new Users("burak","b");;
        myUser.setId(1L);
        roles = new HashSet<>();
        Role r = new Role();
        r.setId(10L);
        r.setRole("ADMIN");
        roles.add(r);
        myUser.setRoleSet(roles);

    }

    @Test
    public void getId() {

        Long id = 1L;

        assertEquals(id,myUser.getId());

    }

    @Test
    public void setId() {

        Long id = 2L;
        myUser.setId(id);

        assertEquals(id,myUser.getId());

    }

    @Test
    public void getUsername() {

        assertEquals("burak",myUser.getUsername());

    }

    @Test
    public void setUsername() {

        myUser.setUsername("bigi");

        assertEquals("bigi",myUser.getUsername());

    }

    @Test
    public void getPassword() {

        assertEquals("b",myUser.getPassword());

    }

    @Test
    public void setPassword() {

        myUser.setPassword("p");

        assertEquals("p",myUser.getPassword());

    }

    @Test
    public void getRoleSet() {

        assertEquals(roles,myUser.getRoleSet());

    }

    @Test
    public void setRoleSet() {

        Set<Role> newRoles = new HashSet<>();
        Role r = new Role();
        r.setId(10L);
        r.setRole("USER");
        newRoles.add(r);
        myUser.setRoleSet(newRoles);
        assertEquals(newRoles,myUser.getRoleSet());

    }
}