package dev.pradyut.cartservices.controllers;


import dev.pradyut.cartservices.models.Cart;
import dev.pradyut.cartservices.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }


    // Get all carts
    @GetMapping("/carts")
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }


    // get a single cart
    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id") Long id){
        return cartService.getSingleCart(id);
    }


    // add a cart
    @PostMapping("/carts")
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }


    //update a cart
    @PutMapping("/carts/{id}")
    public void updateCart(@RequestBody Cart cart,@PathVariable("id") Long id){
        cartService.updateCart(cart,id);
    }


    //delete a cart
    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable("id") Long id){
        cartService.deleteCart(id);
    }



    //cart of a specific user
    @GetMapping("/carts/user/{userId}")
    public List<Cart> getCartsofUser(@PathVariable("userId") Long userId){
        return cartService.getCartsofUser(userId);

    }

    @GetMapping("/carts?startdate={startdate}&enddate={enddate}")
    public List<Cart> getCartsinDate(@RequestParam("startdate") String startdate,
                              @RequestParam("enddate") String enddate){
        return cartService.getCartsinDate(startdate,enddate);
    }


}
