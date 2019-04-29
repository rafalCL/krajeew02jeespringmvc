package pl.coderslab.jeespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.jeespringmvc.beans.Cart;
import pl.coderslab.jeespringmvc.model.CartItem;
import pl.coderslab.jeespringmvc.model.Product;

import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class CartController {
    private Cart cart;

    @Autowired
    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping(path="/cart", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showCart(){
         return this.cart.getCartItems().stream()
                 .map(CartItem::toString)
                 .collect(Collectors.joining("<br/>"));
    }
}
