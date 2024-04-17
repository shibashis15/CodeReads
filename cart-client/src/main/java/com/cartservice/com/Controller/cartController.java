package com.cartservice.com.Controller;

import com.cartservice.com.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{id}")
    public ResponseEntity getAllItem(@PathVariable Long id) { return cartService.createCart(id); }
    @GetMapping("/working")
    public ResponseEntity working() {
        return cartService.working();
    }
    @GetMapping("cart/{id}/create")
    public ResponseEntity createCart(@PathVariable Long id) {
        return cartService.createCart(id);
    }
    @GetMapping("/cart/{user_id}/add/{book_id}")
    public ResponseEntity addItem(@PathVariable Long user_id , @PathVariable Long book_id) {
        return cartService.addItem(user_id , book_id);
    }
    @GetMapping("/cart/{user_id}/remove/{book_id}")
    private ResponseEntity removeItem(@PathVariable Long user_id , @PathVariable Long book_id) {
        return cartService.removeItem(user_id , book_id);
    }
    @GetMapping("cart/all")
    private ResponseEntity allBooksPagination() {
        Pagination pagble =
    }
}
