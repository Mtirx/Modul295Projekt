package ch.csbe.productstore.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition="varchar(100)", nullable = false)
    private String username;

    @Column(columnDefinition="varchar(100)", nullable = false)
    private String password;

    @Column(columnDefinition="varchar(100)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition="varchar(100)", nullable = false)
    private String role = "user";

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
