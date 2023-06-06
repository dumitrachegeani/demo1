package com.example.demo.mcv2;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private String country;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String city, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public static AddressDTO fromAddress(Address address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getCity(), address.getCountry());
    }

    public Address toAddress() {
        Address address = new Address();
        address.setId(id);
        address.setStreet(street);
        address.setCity(city);
        address.setCountry(country);
        return address;
    }
}
