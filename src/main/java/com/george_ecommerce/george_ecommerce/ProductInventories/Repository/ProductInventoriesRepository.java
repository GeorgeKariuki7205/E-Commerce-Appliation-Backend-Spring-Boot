package com.george_ecommerce.george_ecommerce.ProductInventories.Repository;

import com.george_ecommerce.george_ecommerce.ProductInventories.Entity.ProductInventoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoriesRepository extends JpaRepository<ProductInventoriesEntity,Long> {
}
