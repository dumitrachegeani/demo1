package com.example.demo.mcv2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository-ul responsabil pentru accesarea datelor legate de entitatea User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
