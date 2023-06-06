package com.example.demo.mcv2;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Model class for the Company entity.
 */
@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
