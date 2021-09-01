package com.george_ecommerce.george_ecommerce.ProductCategory.Controller;

import com.george_ecommerce.george_ecommerce.ProductCategory.Entity.ProductCategoryEntity;
import com.george_ecommerce.george_ecommerce.ProductCategory.Service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@AllArgsConstructor

@RestController
@RequestMapping(path = "/api/product_category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @RequestMapping(path = "/getting_all_product_categories", method = RequestMethod.GET)
    public ResponseEntity<Object> gettingAllProductCategories(){
        return new ResponseEntity<>(productCategoryService.gettingAllProductCategories(), HttpStatus.OK);
    }

    @RequestMapping(path = "/add_new_product_category", method = RequestMethod.POST)
    public ResponseEntity<Object> addingNewProductCategory(@RequestBody ProductCategoryEntity productCategoryEntity){
        productCategoryEntity.setCreatedAt(new Date());
        return new ResponseEntity<>(productCategoryService.addingNewProductCategory(productCategoryEntity), HttpStatus.OK);

    }

    @RequestMapping(path = "/updating_product_category/{productCategoryId}", method = RequestMethod.POST)
    public ResponseEntity<Object> updatingProductCategory(@PathVariable("productCategoryId") Long productCategoryId,@RequestBody ProductCategoryEntity productCategoryEntity){

        return new ResponseEntity<>(productCategoryService.updatingProductCategory(productCategoryId,productCategoryEntity), HttpStatus.OK);

    }

    @RequestMapping(path = "/deleting_product_category/{productCategoryId}", method = RequestMethod.POST)
    public ResponseEntity<Object> deletingProductCategory(@PathVariable("productCategoryId") Long productCategoryId){

        return new ResponseEntity<>(productCategoryService.deletingProductCategory(productCategoryId), HttpStatus.OK);

    }
}
