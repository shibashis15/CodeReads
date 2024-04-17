package com.Orderservice.com.Service;

import com.Orderservice.com.Dto.CartResponseDto;
import com.Orderservice.com.FeignClient.CartClient;
import com.Orderservice.com.Model.Book;
import com.Orderservice.com.Model.CartResponse;
import com.Orderservice.com.Model.Order;
import com.Orderservice.com.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartClient cartClient;


    @Transactional
    public ResponseEntity setOrder(Long id) {

        CartResponseDto cartResponseDto = cartClient.getCartResponse(id);
        List<Order> orderList = orderRepository.findOrdersByUserId(id);
        if(orderList.isEmpty()) {
            Order order = new Order();
            List<CartResponse> cartResponseList = new ArrayList<>();
            CartResponse cartResponse = new CartResponse();
            cartResponse.setBook((Book) cartResponseDto.getBookList());
            cartResponseList.add(cartResponse);
            order.setOrderItems(cartResponseList);
            order.setUser(cartResponse.);
        }


    }
}
