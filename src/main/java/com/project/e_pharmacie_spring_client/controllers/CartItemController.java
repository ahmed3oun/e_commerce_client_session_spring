package com.project.e_pharmacie_spring_client.controllers;

import java.util.Collections;

import com.project.e_pharmacie_spring_client.models.CartItem;
import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.services.CartItemService;
import com.project.e_pharmacie_spring_client.services.CategoryService;
import com.project.e_pharmacie_spring_client.services.ProductService;
import com.project.e_pharmacie_spring_client.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/cart")
public class CartItemController {

    @Autowired
    CartItemService cartService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    // @DeleteMapping("delete/{id}/user/{u_id}")
    /*
     * @RequestMapping("delete/{id}/user/{id}") public String
     * deleteItem(@PathVariable("id") int id, @PathVariable("u_id") int u_id,Model
     * model) { //cartService.deleteCartItem(id); User user =
     * userService.getUserById(u_id); java.util.List<CartItem> list =
     * cartService.listCartItemsByUser(user); Collections.reverse(list);
     * 
     * model.addAttribute("cart_items_list", list); return "redirect:/cart" + u_id;
     * }
     */
    @RequestMapping("delete/{id}/user/{u_id}")
    public String deleteItemCart(Model model, @PathVariable("id") int id, @PathVariable("u_id") int u_id) {
        cartService.deleteCartItem(id);
        return "redirect:/cart" + u_id;
    }

    @RequestMapping("deleteAllItems/{u_id}")
    public String deleteAllItemCart(@PathVariable("u_id") int u_id) {

        cartService.deleteAllCartItemsByUser(userService.getUserById(u_id));
        return "redirect:/cart" + u_id;
    }

    @GetMapping("cart{u_id}")
    public String showCartPage2(Model model, @PathVariable("u_id") int u_id) {

        model.addAttribute("category_list", categoryService.listAllCategories());
        System.out
                .print("------------------------------------------------------------------------<<<>>-----:: " + u_id);
        User user = userService.getUserById(u_id);
        java.util.List<CartItem> list = cartService.listCartItemsByUser(user);
        Collections.reverse(list);

        model.addAttribute("cart_items_list", list);
        return "cart";
    }

}