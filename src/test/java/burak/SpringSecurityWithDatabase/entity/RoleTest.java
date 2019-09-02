package burak.SpringSecurityWithDatabase.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleTest {

    Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role();

        role.setId(1L);
        role.setRole("ADMIN");

    }

    @Test
    public void getId() {

        Long id = 1L;

        assertEquals(id,role.getId());

    }

    @Test
    public void setId() {

        Long id = 2L;

        role.setId(id);

        assertEquals(id,role.getId());

    }

    @Test
    public void getRole() {

        assertEquals("ADMIN",role.getRole());

    }

    @Test
    public void setRole() {

        role.setRole("USER");

        assertEquals("USER",role.getRole());

    }
}