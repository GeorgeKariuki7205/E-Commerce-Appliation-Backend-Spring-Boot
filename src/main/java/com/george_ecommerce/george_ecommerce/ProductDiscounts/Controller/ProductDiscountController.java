package com.george_ecommerce.george_ecommerce.ProductDiscounts.Controller;

import com.george_ecommerce.george_ecommerce.ProductDiscounts.Entity.ProductDiscountsEntity;
import com.george_ecommerce.george_ecommerce.ProductDiscounts.Service.ProductDiscountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/product_discount")
public class ProductDiscountController {

    private final ProductDiscountService productDiscountService;

    @RequestMapping(path = "/get_all_product_discounts", method = RequestMethod.GET)
    public ResponseEntity<Object> gettingAllProductDiscount() {

        return new ResponseEntity<>(productDiscountService.getAllProductDiscounts(), HttpStatus.OK);
    }

    @RequestMapping(path = "/add_new_product_discounts", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewProductDiscount(@RequestBody ProductDiscountsEntity productDiscountsEntity) {

        return new ResponseEntity<>(productDiscountService.addNewProductDiscount(productDiscountsEntity), HttpStatus.OK);
    }

    @RequestMapping(path = "/updating_product_discounts/{productDiscount}", method = RequestMethod.POST)
    public ResponseEntity<Object> updatingProductDiscount(@PathVariable("productDiscount") Long productDiscount, @RequestBody ProductDiscountsEntity productDiscountsEntity) {

        return new ResponseEntity<>(productDiscountService.updatingProductDiscount(productDiscount, productDiscountsEntity), HttpStatus.OK);
    }

    @RequestMapping(path = "/deleting_product_discounts/{productDiscount}", method = RequestMethod.POST)
    public ResponseEntity<Object> updatingProductDiscount(@PathVariable("productDiscount") Long productDiscount) {

        return new ResponseEntity<>(productDiscountService.deletingProductDiscount(productDiscount), HttpStatus.OK);
    }

}
