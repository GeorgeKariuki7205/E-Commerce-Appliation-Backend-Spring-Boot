package com.george_ecommerce.george_ecommerce.ProductInventories.Service;

import com.george_ecommerce.george_ecommerce.ProductInventories.Entity.ProductInventoriesEntity;
import com.george_ecommerce.george_ecommerce.ProductInventories.Repository.ProductInventoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ProductInventoriesService {
    private final ProductInventoriesRepository productInventoriesRepository;

    public Object gettingAllProductInventories() {
        return productInventoriesRepository.findAll();
    }

    public Object addingNewProductInventories(ProductInventoriesEntity productInventoriesEntity) {

        productInventoriesRepository.save(productInventoriesEntity);
        return this.gettingAllProductInventories();
    }

    @Transactional
    public Object updatingProductInventory(Long productInventory, ProductInventoriesEntity productInventoriesEntity) {

        ProductInventoriesEntity productInventories = productInventoriesRepository.findById(productInventory).orElseThrow(()-> new IllegalStateException("THE PRODUCT INVENTORY WITH THE ID NOT FOUND."));

        productInventories.setUpdatedAt(productInventoriesEntity.getUpdatedAt());
        productInventories.setUpdatedBy(productInventoriesEntity.getUpdatedBy());
        productInventories.setProductQuantity(productInventoriesEntity.getProductQuantity());

        return this.gettingAllProductInventories();
    }

    public Object deletingProductInventory(Long productInventory) {
        ProductInventoriesEntity productInventories = productInventoriesRepository.findById(productInventory).orElseThrow(()-> new IllegalStateException("THE PRODUCT INVENTORY WITH THE ID NOT FOUND."));

        productInventoriesRepository.deleteById(productInventory);

        return this.gettingAllProductInventories();
    }
}
