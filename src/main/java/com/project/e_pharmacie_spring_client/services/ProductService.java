package com.project.e_pharmacie_spring_client.services;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.Category;
import com.project.e_pharmacie_spring_client.models.Product;
import com.project.e_pharmacie_spring_client.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> listAllProducts() {
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(Category category) {
        return repository.listProductByCategory(category);
    }

    public Product getProductById(int id) {
        return repository.getOne(id);
    }

    public void deleteProduct(int id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.getOne(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setCategory(product.getCategory());
        return repository.save(existingProduct);
    }

}