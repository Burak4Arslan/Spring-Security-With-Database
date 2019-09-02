package burak.SpringSecurityWithDatabase.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_table")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name="username" ,unique=true)
    private String username;
    @Column(name="password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns =  @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

    public Users(Users user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleSet = user.getRoleSet();
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.setRoleSet(new HashSet<>());
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
