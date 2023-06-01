package com.example.demo.mcv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller-ul responsabil pentru gestionarea cererilor legate de entitatea User.
 */
@RestController
public class UserController {

    private final UserService userService;

    /**
     * Constructorul care injectează dependența către UserService.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        // TODO:xdd
    }

    /**
     * Endpoint-ul pentru obținerea tuturor utilizatorilor.
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint-ul pentru crearea unui nou utilizator.
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Endpoint-ul pentru obținerea unui utilizator după ID.
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Endpoint-ul pentru actualizarea unui utilizator existent.
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Endpoint-ul pentru ștergerea unui utilizator după ID.
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
