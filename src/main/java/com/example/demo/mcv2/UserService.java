package com.example.demo.mcv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviciul responsabil pentru logica de afaceri legată de entitatea User.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructorul care injectează dependența către UserRepository.
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returnează lista tuturor utilizatorilor.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Creează un nou utilizator.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Returnează un utilizator după ID.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Actualizează un utilizator existent.
     */
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    /**
     * Șterge un utilizator după ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

