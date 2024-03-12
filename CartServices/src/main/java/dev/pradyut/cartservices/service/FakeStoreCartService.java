package dev.pradyut.cartservices.service;

import dev.pradyut.cartservices.dtos.FakeStoreCartDto;
import dev.pradyut.cartservices.models.Cart;
import dev.pradyut.cartservices.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.CachingResourceTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreCartService implements CartService {
    private RestTemplate restTemplate = new RestTemplate();


    // to get all carts
    public List<Cart> getAllCarts(){
        FakeStoreCartDto[]  listOfCarts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                FakeStoreCartDto[].class
        );
        ArrayList<Cart> cartList = new ArrayList<>();
        for(int i = 0; i<(Objects.requireNonNull(listOfCarts)).length; i++){
            Cart newCart = new Cart();
            FakeStoreCartDto temp = listOfCarts[i];
            newCart.setId(temp.getId());
            newCart.setUserId(temp.getUserId());
            newCart.setDate(temp.getDate());
            newCart.setProducts(temp.getProducts());

            cartList.add(newCart);
        }
        return cartList;
    }




    // to get a single cart
    public Cart getSingleCart(Long id){
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                FakeStoreCartDto.class
        );
        Cart cart = new Cart();
        assert fakeStoreCartDto != null;
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setProducts(fakeStoreCartDto.getProducts());

        return cart;
    }



    //Add a cart
    public Cart createCart(Cart cart) {
        FakeStoreCartDto temp = new FakeStoreCartDto();

        temp.setId(cart.getId());
        temp.setUserId(cart.getUserId());
        temp.setDate(cart.getDate());
        temp.setProducts(cart.getProducts());

        FakeStoreCartDto fakeStoreCartDto = restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                temp,
                FakeStoreCartDto.class
        );
        return cart;
    }



    //update a cart
    public void updateCart(Cart cart, Long id) {
        FakeStoreCartDto temp = new FakeStoreCartDto();

        temp.setId(cart.getId());
        temp.setUserId(cart.getUserId());
        temp.setDate(cart.getDate());
        temp.setProducts(cart.getProducts());

        restTemplate.put(
                "https://fakestoreapi.com/carts/" + id,
                temp,
                FakeStoreCartDto.class
        );

    }

    //Delete a Cart
    public void deleteCart(Long id) {
        restTemplate.delete(
                "https://fakestoreapi.com/carts/" + id
        );
    }

    // get cart of a particular user
    public List<Cart> getCartsofUser(Long userId) {
        FakeStoreCartDto[]  listOfCarts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/"+ userId,
                FakeStoreCartDto[].class
        );
        ArrayList<Cart> cartList = new ArrayList<>();
        for(int i = 0; i<(Objects.requireNonNull(listOfCarts)).length; i++){
            Cart newCart = new Cart();
            FakeStoreCartDto temp = listOfCarts[i];

            newCart.setId(temp.getId());
            newCart.setUserId(temp.getUserId());
            newCart.setDate(temp.getDate());
            newCart.setProducts(temp.getProducts());

            cartList.add(newCart);
        }
        return cartList;
    }



    //get cart in a particular date range
    public List<Cart> getCartsinDate(String startdate, String enddate) {
        FakeStoreCartDto[]  listOfDateCarts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate="+startdate+"&enddate="+enddate,
                FakeStoreCartDto[].class
        );

        ArrayList<Cart> cartListDate = new ArrayList<>();
        for(int i = 0; i<(Objects.requireNonNull(listOfDateCarts)).length; i++){
            Cart newCart = new Cart();
            FakeStoreCartDto temp = listOfDateCarts[i];
            newCart.setId(temp.getId());
            newCart.setUserId(temp.getUserId());
            newCart.setDate(temp.getDate());
            newCart.setProducts(temp.getProducts());

            cartListDate.add(newCart);
        }
        return cartListDate;


    }
}
