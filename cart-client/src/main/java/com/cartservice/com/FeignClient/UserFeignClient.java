package com.cartservice.com.FeignClient;

import com.cartservice.com.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user")
public interface UserFeignClient {
    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    UserDto getUserById(@PathVariable Long id);
}
