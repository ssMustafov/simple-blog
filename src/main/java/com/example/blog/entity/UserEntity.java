package com.example.blog.entity;

import com.example.blog.models.UserRole;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author smustafov
 */
@Entity
@Table(name = "users", indexes = {
        @Index(name = "users_index_username", columnList = "username", unique = true)
})
public class UserEntity extends BaseAuditableEntity {

    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 512, nullable = false)
    private String password;

    @Column(name = "role", length = 16, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                role == that.role &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, role, email);
    }
}
