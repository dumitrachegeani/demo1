package com.example.demo.mcv2;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Serviciul responsabil pentru logica de afaceri legată de entitatea User.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;

    /**
     * Constructorul care injectează dependența către UserRepository.
     */
    @Autowired
    public UserService(UserRepository userRepository, ProductRepository productRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
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

        // Save the user entity in the database
        User createdUser = userRepository.save(user);

        // Set the user for each product
        List<Product> products = user.getProducts();
        if (products != null && !products.isEmpty()) {
            productRepository.saveAll(products);
        }

        // Save the associated addresses
        List<Address> addresses = user.getAddresses();
        if (addresses != null && !addresses.isEmpty()) {
            addresses.forEach(address -> address.setUser(createdUser));
            addressRepository.saveAll(addresses);
        }

        return createdUser;
    }

    /**
     * Returnează un utilizator după ID.
     */
    public User getUserById(Long id) throws UserNotFound {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("User not found"));
    }

    /**
     * Actualizează un utilizator existent.
     */
    public User updateUser(Long id, User user) throws UserNotFound {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("User not found"));
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

