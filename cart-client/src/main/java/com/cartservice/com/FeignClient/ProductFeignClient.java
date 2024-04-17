package com.cartservice.com.FeignClient;

import com.cartservice.com.Dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("book")
public interface ProductFeignClient {
    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    BookDto getBookDetails(@PathVariable Long id);
}
