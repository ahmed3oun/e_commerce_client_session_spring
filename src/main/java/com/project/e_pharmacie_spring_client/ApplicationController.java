package com.project.e_pharmacie_spring_client;

import javax.servlet.http.HttpSession;

import com.project.e_pharmacie_spring_client.models.CartItem;
import com.project.e_pharmacie_spring_client.models.Product;
import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.services.CartItemService;
import com.project.e_pharmacie_spring_client.services.CategoryService;
import com.project.e_pharmacie_spring_client.services.ProductService;
import com.project.e_pharmacie_spring_client.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    CartItemService cartService;

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("category_list", categoryService.listAllCategories());

        return "index";
    }

    @GetMapping("/login")
    public String index() {

        return "login";
    }

    @GetMapping("/register")
    public String ShowRegisterPage(Model model) {

        model.addAttribute("users", new User());
        return "register";
    }

    /*
     * @GetMapping("cart{u_id}") //@RequestMapping("cart{u_id}") public String
     * showCartPage(Model model, @PathVariable("u_id") int u_id) {
     * model.addAttribute("category_list", categoryService.listAllCategories());
     * 
     * model.addAttribute("cart_items_list",
     * cartService.listCartItemsByUser(userService.getUserById(u_id)));
     * 
     * return "cart"; }
     */

    // @PostMapping("/addToCart/{u_id}/product/{p_id}")
    /*
     * @RequestMapping(value = "/addToCart{u_id}/product{p_id}" , method =
     * RequestMethod.POST) public String addItemCart(@PathVariable("u_id") int
     * u_id, @PathVariable("p_id") int p_id) {
     * 
     * Product product = productService.getProductById(p_id); User user =
     * userService.getUserById(u_id);
     * 
     * CartItem item = new CartItem(); item.setProduct(product); item.setUser(user);
     * cartService.saveCartItem(item);
     * 
     * return "redirect:/cart" + u_id; }
     */
    @RequestMapping(value = "/addToCart/{u_id}/product/{p_id}", method = { RequestMethod.POST, RequestMethod.GET })
    public String addItemCart(@PathVariable("u_id") int u_id, @PathVariable("p_id") int p_id) {

        Product product = productService.getProductById(p_id);
        User user = userService.getUserById(u_id);

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setUser(user);
        cartService.saveCartItem(item);

        // return "redirect:/cart" + u_id;
        return "redirect:/cart" + u_id;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("users") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/checklogin")
    public String checklogin(ModelMap model, @RequestParam("mail") String mail,
            @RequestParam("password") String password, HttpSession Httpsession) {
        if (userService.getUserBymail(mail).getMail().equals(mail)
                && userService.getUserBymail(mail).getPassword().equals(password)) {
            Httpsession.setAttribute("mail", userService.getUserBymail(mail).getName());
            Httpsession.setAttribute("id", userService.getUserBymail(mail).getId());
            return "redirect:/index";
        } else {

            return "login";
        }

    }

}
