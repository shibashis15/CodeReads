package com.cartservice.com.Service;


import com.cartservice.com.Dto.BookDto;
import com.cartservice.com.Dto.CartResponse;
import com.cartservice.com.Dto.UserDto;
import com.cartservice.com.FeignClient.ProductFeignClient;
import com.cartservice.com.FeignClient.UserFeignClient;
import com.cartservice.com.Model.Cart;
import com.cartservice.com.Repository.CartRepository;
import com.cartservice.com.util.ProductDoesNotExists;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    public ResponseEntity working() {
        Long id = 22L;
        BookDto bookDto = productFeignClient.getBookDetails(id);
        logger.info("Service working");
        return ResponseEntity.ok(bookDto);
    }
    public boolean IsCartExists(Long userId) {
        return cartRepository.findByUserId(userId) == null;
    }
    public ResponseEntity createCart(Long userId) {
        if (IsCartExists(userId)) {
            Cart cart = new Cart();
            cart.setId(userId);
            cart.setUserId(userId);
            cart.setItems(new HashMap<>());
            cartRepository.save(cart);
            logger.info("Cart Created for User :" + userId);
            return getAllItems(cart);
        }
        return ResponseEntity.ok(getAllItems(cartRepository.findAllByUserId(userId)));
    }

    public ResponseEntity getAllItems(Cart cart) {
        logger.info("User - "+ cart.getUserId() + "Using Cart Service");
        @NotNull Double total_price = 0.0;
        Map<Long , Integer> itemsMap = cart.getItems();
        List<BookDto> bookDtoList = new ArrayList<>();
        for(Map.Entry<Long, Integer> entry : itemsMap.entrySet()) {
            Long bookId = entry.getKey();
            int quantity = entry.getValue();
            BookDto bookDto = productFeignClient.getBookDetails(bookId);
            bookDto.setQuantity(quantity);
            bookDtoList.add(bookDto);
            total_price+=((bookDto.getBookPrice() - bookDto.getDiscount())*quantity);
        }

        UserDto userDto = userFeignClient.getUserById(cart.getUserId());
        CartResponse cartResponse = new CartResponse(userDto , cart.getId() , bookDtoList , total_price);
        return ResponseEntity.ok(cartResponse);
    }

    public ResponseEntity addItem(Long userId , Long bookId) {
        BookDto bookDto = productFeignClient.getBookDetails(bookId);
        if(bookDto == null) throw new ProductDoesNotExists("Book Does Not Exist");
        Cart cart = cartRepository.findByUserId(userId);
        Map<Long , Integer> itemsMap = cart.getItems();
        itemsMap.put(bookId , itemsMap.getOrDefault(bookId , 0)+1);
        cart.setItems(itemsMap);
        cartRepository.save(cart);
        logger.info("Added : " +bookDto.getBookName() + ", Quantity : " + itemsMap.get(bookId));
        return ResponseEntity.ok("Added : " +bookDto.getBookName() + ", Quantity : " + itemsMap.get(bookId));
    }

    public ResponseEntity removeItem(Long userId , Long bookId) {
        Cart cart = cartRepository.findAllByUserId(userId);
        Map<Long , Integer> bookDtoMap= cart.getItems();
        int quantity = bookDtoMap.get(bookId);
        if(quantity > 1)
            bookDtoMap.put(bookId , quantity - 1);
        else
            bookDtoMap.remove(bookId);
        cart.setItems(bookDtoMap);
        cartRepository.save(cart);
        logger.info("UserID - " + userId + " removed Book Id - " +bookId);
        return ResponseEntity.ok("Book - " + bookId + " removed!!");
    }
}

