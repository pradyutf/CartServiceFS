package dev.pradyut.cartservices.service;

import dev.pradyut.cartservices.models.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getSingleCart(Long id);
    Cart createCart(Cart cart);
    void updateCart(Cart cart,Long id);
    void deleteCart(Long id);
    List<Cart> getCartsofUser(Long userId);
    List<Cart> getCartsinDate(String startdate, String enddate);
}
