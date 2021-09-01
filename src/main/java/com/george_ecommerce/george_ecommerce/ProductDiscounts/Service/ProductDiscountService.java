package com.george_ecommerce.george_ecommerce.ProductDiscounts.Service;

import com.george_ecommerce.george_ecommerce.ProductDiscounts.Entity.ProductDiscountsEntity;
import com.george_ecommerce.george_ecommerce.ProductDiscounts.Repository.ProductDiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ProductDiscountService {

    private final ProductDiscountRepository productDiscountRepository;


    public Object getAllProductDiscounts() {

        return productDiscountRepository.findAll();
    }

    public Object addNewProductDiscount(ProductDiscountsEntity productDiscountsEntity) {

        productDiscountRepository.save(productDiscountsEntity);

        return this.getAllProductDiscounts();

    }

    @Transactional
    public Object updatingProductDiscount(Long productDiscount, ProductDiscountsEntity productDiscountsEntity) {

        ProductDiscountsEntity productDiscounts = productDiscountRepository.findById(productDiscount).orElseThrow(() -> new IllegalStateException(("THE DISCOUNT WITH THE PARTICULAR ID DOES NOT EXIST.")));

        productDiscounts.setUpdatedAt(productDiscountsEntity.getUpdatedAt());
        productDiscounts.setUpdatedBy(productDiscountsEntity.getUpdatedBy());
        productDiscounts.setProductDiscountName(productDiscountsEntity.getProductDiscountName());
        productDiscounts.setProductDiscountDescription(productDiscountsEntity.getProductDiscountDescription());
        productDiscounts.setProductDiscountPercentage(productDiscountsEntity.getProductDiscountPercentage());

        return this.getAllProductDiscounts();
    }

    public Object deletingProductDiscount(Long productDiscount) {

        ProductDiscountsEntity productDiscounts = productDiscountRepository.findById(productDiscount).orElseThrow(() -> new IllegalStateException(("THE DISCOUNT WITH THE PARTICULAR ID DOES NOT EXIST.")));

        productDiscountRepository.deleteById(productDiscount);

        return this.getAllProductDiscounts();

    }
}
