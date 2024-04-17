package com.cartservice.com.Repository;

import com.cartservice.com.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart findAllByUserId(Long id);

    Cart findByUserId(Long userId);
}
