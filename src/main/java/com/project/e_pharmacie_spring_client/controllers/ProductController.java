package com.project.e_pharmacie_spring_client.controllers;

import com.project.e_pharmacie_spring_client.models.Category;
import com.project.e_pharmacie_spring_client.services.CategoryService;
import com.project.e_pharmacie_spring_client.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "{id}" , method = RequestMethod.GET)
    //@GetMapping("{id}")
    public String showProductsByCategory(@PathVariable("id") int id, Model model) {

        Category category = categoryService.getCategoryById(id);
        
        model.addAttribute("product_list", productService.getProductsByCategory(category));
        model.addAttribute("category_list", categoryService.listAllCategories());
        return "product";
    }

    @GetMapping("products")
    public String showProducts(Model model) {
        model.addAttribute("product_list", productService.listAllProducts());
        model.addAttribute("category_list", categoryService.listAllCategories());

        return "product";
    }


}