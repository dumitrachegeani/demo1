package com.example.demo.mcv2;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Model class for the Address entity.
 */
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;

    private String city;

    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "address")
    private Company company;

}
