package com.example.demo.mcv2;


import jakarta.persistence.*;
import lombok.Data;

/**
 * Modelul de date pentru entitatea Product.
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String description;

}