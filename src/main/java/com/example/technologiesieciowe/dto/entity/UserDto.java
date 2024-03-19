package com.example.technologiesieciowe.dto.entity;

public class UserDto {
    private Integer Id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String fullUsername;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
    }
}
