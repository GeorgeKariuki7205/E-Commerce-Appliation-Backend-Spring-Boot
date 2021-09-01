package com.george_ecommerce.george_ecommerce.Products.Controller;

import com.george_ecommerce.george_ecommerce.Products.Service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor

public class ProductsController {
    private final ProductsService productsService;
}
