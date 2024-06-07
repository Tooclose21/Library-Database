package com.example.technologiesieciowe.entity;

import jakarta.persistence.*;

/**
 * The type User.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(unique = true)
        private String username;
        private String password;
        private String role;
        private String email;
        private String fullUsername;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        Id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets full username.
     *
     * @return the full username
     */
    public String getFullUsername() {
        return fullUsername;
    }

    /**
     * Sets full username.
     *
     * @param fullUsername the full username
     */
    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
    }
}
