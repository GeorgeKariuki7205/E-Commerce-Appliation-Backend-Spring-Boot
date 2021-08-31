package com.george_ecommerce.georg_ecommerce.CartItems.Repository;

import com.george_ecommerce.georg_ecommerce.CartItems.Entity.CartItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItemsEntity,Long> {

}
