package org.example.service;


import org.example.Entity.Product;

public interface ProductService {
    public void getAll();
    public boolean searchById(Long key);
    public void searchByName(String key);
    public void searchByCategory(String key);
    public void searchByProducer(String key);
    public void searchByPrice(Long key);
    public void create(Product product);
    public void update(Product product,Long id);
    public void deleteById(Long id);

}
