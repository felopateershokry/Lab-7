/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< Updated upstream:src/javaapplication12/User.java
package javaapplication12;
=======
package skillfrog;
>>>>>>> Stashed changes:src/skillfrog/User.java

/**
 *
 * @author GAMING
 */
public abstract class User {

    protected int userId;
    protected String role;
    protected String username;
    protected String email;
    protected String passwordHash;

    public User() {
        this.userId = 0;
        this.role = "";
        this.passwordHash = "*****";
        this.role = "";
        this.email = "@";
    }

    public User(int id, String rol, String email, String pass, String name) {
        this.userId = id;
        this.role = rol;
        this.email = email;
        this.passwordHash = pass;
        this.username = name;

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

}
