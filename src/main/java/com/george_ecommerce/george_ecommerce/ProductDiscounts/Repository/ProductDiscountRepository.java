package com.george_ecommerce.george_ecommerce.ProductDiscounts.Repository;

import com.george_ecommerce.george_ecommerce.ProductDiscounts.Entity.ProductDiscountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscountsEntity, Long> {
}
