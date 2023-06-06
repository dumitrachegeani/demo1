package com.example.demo.mcv2;


import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;

    public ProductDTO(Long id, String productName, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }

    public static ProductDTO fromProduct(Product product) {
        return new ProductDTO(product.getId(), product.getProductName(), product.getDescription());
    }

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setProductName(productName);
        product.setDescription(description);
        return product;
    }
}

