package org.example.Entity;

public class Product {
    private Long id;
    private String productName;
    private String description;
    private String category;
    private String producer;
    private Long price;

    public Product() {
    }

    public Product(String productName, String description, String category, String producer, Long price) {
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.producer = producer;
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", productName=" + productName  +
                ", description=" + description  +
                ", category=" + category  +
                ", producer=" + producer +
                ", price="+ price;
    }
}
