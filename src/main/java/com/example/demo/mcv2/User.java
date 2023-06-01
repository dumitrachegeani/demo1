package com.example.demo.mcv2;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.Target;

/**
 * Modelul de date pentru entitatea User.
 */
@Entity
@Getter
@Setter
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

}