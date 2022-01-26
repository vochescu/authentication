package com.demo.authentication.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;

    private String password;
    @Column(name = "creation_timestamp")
    private String creationTimestamp;
    @Column(name = "access")
    private Role role;

    public User(){
    }

    public User(String username, String password, String creationTimestamp, Role role) {
        this.username = username;
        this.password = password;
        this.creationTimestamp = creationTimestamp;
        this.role = role;
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

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", creationTimestamp=" + creationTimestamp +
                ", role=" + role +
                '}';
    }
}


