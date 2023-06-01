package com.example.demo.mcv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFound e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Endpoint-ul pentru actualizarea unui utilizator existent.
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            return userService.updateUser(id, user);
        } catch (UserNotFound e) {
            // aici ar trebui gestionat
            throw new RuntimeException(e);
        }
    }

    /**
     * Endpoint-ul pentru ștergerea unui utilizator după ID.
     */
    @DeleteMapping("/users")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "Sters cu succes";
    }
}
