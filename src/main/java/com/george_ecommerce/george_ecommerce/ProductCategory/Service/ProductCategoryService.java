package com.george_ecommerce.george_ecommerce.ProductCategory.Service;

import com.george_ecommerce.george_ecommerce.ProductCategory.Entity.ProductCategoryEntity;
import com.george_ecommerce.george_ecommerce.ProductCategory.Repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public Object gettingAllProductCategories(){
        return productCategoryRepository.findAll();
    }

    public Object addingNewProductCategory(ProductCategoryEntity productCategoryEntity) {
        productCategoryRepository.save(productCategoryEntity);
        return this.gettingAllProductCategories();
    }


    @Transactional
    public Object updatingProductCategory(Long productCategoryId, ProductCategoryEntity productCategoryEntity) {
        ProductCategoryEntity productCategory = productCategoryRepository.findById(productCategoryId).orElseThrow(()-> new IllegalStateException("NO PRODUCT CATEGORY WITH THAT ID EXISTS."));

        productCategory.setProductCategoryName(productCategoryEntity.getProductCategoryName());
        productCategory.setUpdatedAt(productCategoryEntity.getUpdatedAt());
        productCategory.setUpdatedBy(productCategoryEntity.getUpdatedBy());

        return this.gettingAllProductCategories();

    }

    public Object deletingProductCategory(Long productCategoryId) {
        ProductCategoryEntity productCategory = productCategoryRepository.findById(productCategoryId).orElseThrow(()-> new IllegalStateException("NO PRODUCT CATEGORY WITH THAT ID EXISTS."));

        productCategoryRepository.deleteById(productCategoryId);

        return this.gettingAllProductCategories();
    }
}
