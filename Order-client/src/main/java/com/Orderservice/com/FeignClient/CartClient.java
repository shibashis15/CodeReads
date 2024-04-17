package com.Orderservice.com.FeignClient;

import com.Orderservice.com.Dto.CartResponseDto;
import com.Orderservice.com.Model.CartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cart")
public interface CartClient {
    @RequestMapping(method = RequestMethod.GET , value = "/cart/{id}")
    public CartResponseDto getCartResponse(@PathVariable Long id);
}
