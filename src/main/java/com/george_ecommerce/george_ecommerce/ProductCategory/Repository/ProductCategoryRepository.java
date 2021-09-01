package com.george_ecommerce.george_ecommerce.ProductCategory.Repository;

import com.george_ecommerce.george_ecommerce.ProductCategory.Entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity,Long> {
}
