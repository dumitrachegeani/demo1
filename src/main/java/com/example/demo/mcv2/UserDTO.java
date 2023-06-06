package com.example.demo.mcv2;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private List<ProductDTO> products;
    private List<AddressDTO> addresses;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, List<ProductDTO> products, List<AddressDTO> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.products = products;
        this.addresses = addresses;
    }

    public static UserDTO fromUser(User user) {
        List<ProductDTO> productDTOs = user.getProducts().stream()
                .map(ProductDTO::fromProduct)
                .collect(Collectors.toList());
        List<AddressDTO> addressDTOs = user.getAddresses().stream()
                .map(AddressDTO::fromAddress)
                .collect(Collectors.toList());
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), productDTOs, addressDTOs);
    }

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        List<Product> products = this.products.stream()
                .map(ProductDTO::toProduct)
                .collect(Collectors.toList());
        user.setProducts(products);
        List<Address> addresses = this.addresses.stream()
                .map(AddressDTO::toAddress)
                .collect(Collectors.toList());
        user.setAddresses(addresses);
        return user;
    }
}

