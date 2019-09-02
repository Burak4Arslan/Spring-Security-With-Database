package burak.SpringSecurityWithDatabase.service;

import burak.SpringSecurityWithDatabase.entity.Role;
import burak.SpringSecurityWithDatabase.repository.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RoleServiceImplTest {

    @Mock
    RoleRepository roleRepository;

    RoleService roleService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        roleService = new RoleServiceImpl(roleRepository);
    }

    @Test
    public void findAll() {

        Role role1 = new Role();
        role1.setId(1L);

        Role role2 = new Role();
        role2.setId(2L);

        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);

        when(roleRepository.findAll()).thenReturn(roleList);

        List<Role> roles = roleService.findAll();

        verify(roleRepository,times(1)).findAll();
        assertEquals(roleList,roles);

    }

    @Test
    public void findById() {
    }

    @Test
    public void findByRole() {

        Role role1 = new Role();
        role1.setId(1L);
        role1.setRole("ADMIN");

        Role role2 = new Role();
        role2.setId(2L);
        role2.setRole("USER");

        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);

        when(roleRepository.findByRole("ADMIN")).thenReturn(role1);

        Role returnedRole = roleService.findByRole("ADMIN");

        verify(roleRepository,times(1)).findByRole("ADMIN");
        assertEquals(role1,returnedRole);

    }
}