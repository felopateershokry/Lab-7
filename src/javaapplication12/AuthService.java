/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication12;

import java.util.List;

/**
 *
 * @author GAMING
 */
public class AuthService {

    private JsonDatabaseManager dbManager;
    private List<User> users;
    private User loggedInUser = null;

    public AuthService(JsonDatabaseManager dbManager) {
        this.dbManager = dbManager;
        this.users = dbManager.loadUsers();
    }
}
