package com.george_ecommerce.george_ecommerce.Products.Service;

import com.george_ecommerce.george_ecommerce.Products.Repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;
}
