package com.george_ecommerce.george_ecommerce.ProductInventories.Controller;

import com.george_ecommerce.george_ecommerce.ProductCategory.Service.ProductCategoryService;
import com.george_ecommerce.george_ecommerce.ProductInventories.Entity.ProductInventoriesEntity;
import com.george_ecommerce.george_ecommerce.ProductInventories.Service.ProductInventoriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping( path = "api/product_inventory")
public class ProductInventoriesController {

    private final ProductInventoriesService productInventoriesService;

    @RequestMapping(path = "/getting_all_product_inventories", method = RequestMethod.GET)
    public ResponseEntity<Object> gettingAllProductInventories(){

        return  new ResponseEntity<>(productInventoriesService.gettingAllProductInventories(), HttpStatus.OK);

    }

    @RequestMapping(path = "/adding_new_product_inventories", method = RequestMethod.POST)
    public ResponseEntity<Object> addingNewProductInventories(@RequestBody ProductInventoriesEntity productInventoriesEntity){

        return  new ResponseEntity<>(productInventoriesService.addingNewProductInventories(productInventoriesEntity), HttpStatus.OK);

    }

    @RequestMapping(path = "/updating_product_inventories/{productInventory}", method = RequestMethod.POST)
    public ResponseEntity<Object> updatingProductInventory(@PathVariable("productInventory") Long productInventory, @RequestBody ProductInventoriesEntity productInventoriesEntity){

        return  new ResponseEntity<>(productInventoriesService.updatingProductInventory(productInventory,productInventoriesEntity), HttpStatus.OK);

    }

    @RequestMapping(path = "/deleting_product_inventories/{productInventory}", method = RequestMethod.POST)
    public ResponseEntity<Object> deletingProductInventory(@PathVariable("productInventory") Long productInventory){

        return  new ResponseEntity<>(productInventoriesService.deletingProductInventory(productInventory), HttpStatus.OK);

    }
}
