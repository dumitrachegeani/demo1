package com.example.demo.mcv2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
