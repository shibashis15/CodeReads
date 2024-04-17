package com.Orderservice.com.Dto;

import com.Orderservice.com.Model.CartResponse;
import com.Orderservice.com.Model.User;
import com.Orderservice.com.util.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDto user;
    private List<CartResponse> orderItems;
    private LocalDateTime orderDate;
    private OrderStatus status;
}
