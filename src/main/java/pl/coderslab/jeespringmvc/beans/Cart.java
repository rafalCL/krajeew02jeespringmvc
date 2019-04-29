package pl.coderslab.jeespringmvc.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.jeespringmvc.model.CartItem;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
