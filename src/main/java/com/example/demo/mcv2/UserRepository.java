package com.example.demo.mcv2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository-ul responsabil pentru accesarea datelor legate de entitatea User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNameStartsWithIgnoreCaseAndEmailContainsIgnoreCase(String name, String email);

    List<User> findByNameLike(String name);

    @Query("SELECT u FROM User u WHERE u.email LIKE '%.com'")
    List<User> findEmailsWithDot();


}
