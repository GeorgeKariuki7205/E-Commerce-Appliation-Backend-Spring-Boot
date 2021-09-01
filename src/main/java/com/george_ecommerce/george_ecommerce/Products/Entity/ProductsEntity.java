package com.george_ecommerce.george_ecommerce.Products.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.george_ecommerce.george_ecommerce.ProductCategory.Entity.ProductCategoryEntity;
import com.george_ecommerce.george_ecommerce.ProductDiscounts.Entity.ProductDiscountsEntity;
import com.george_ecommerce.george_ecommerce.ProductInventories.Entity.ProductInventoriesEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_products")
public class ProductsEntity {
    @Id
    @SequenceGenerator(
            name = "z_sequence_product",
            sequenceName = "z_sequence_product",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_product",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @JsonBackReference(value = "product_category_id")
    @ManyToOne()
    @JoinColumn(
            name = "product_category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "product_category_id"
            )
    )
    private ProductCategoryEntity productCategoryEntity;

    @JsonBackReference(value = "product_discount_id")
    @ManyToOne()
    @JoinColumn(
            name = "product_discount_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "product_discount_id"
            )
    )
    private ProductDiscountsEntity productDiscountsEntity;

    @JsonBackReference(value = "product_inventory_id")
    @ManyToOne()
    @JoinColumn(
            name = "product_inventory_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "product_inventory_id"
            )
    )
    private ProductInventoriesEntity productInventoriesEntity;


    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

}
