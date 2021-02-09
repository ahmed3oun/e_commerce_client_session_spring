package com.project.e_pharmacie_spring_client.repositories;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.Category;
import com.project.e_pharmacie_spring_client.models.Product;

public interface ProductRepositoryCustom {
    List<Product> listProductByCategory(Category category);
}
