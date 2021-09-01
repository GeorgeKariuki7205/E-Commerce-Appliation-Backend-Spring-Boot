package com.george_ecommerce.george_ecommerce.Products.Repository;

import com.george_ecommerce.george_ecommerce.Products.Entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
}
