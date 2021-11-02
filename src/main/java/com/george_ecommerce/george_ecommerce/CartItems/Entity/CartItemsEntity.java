package com.george_ecommerce.george_ecommerce.CartItems.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.george_ecommerce.george_ecommerce.Products.Entity.ProductsEntity;
import com.george_ecommerce.george_ecommerce.Users.Entity.UsersEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_cart_cart_items")
public class CartItemsEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_cart_items",
            sequenceName = "z_sequence_cart_items",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_cart_items",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long cartItemId;

    //    ! CREATING THE FOREIGN KEY TO THE USERS TABLE.

    @JsonBackReference(value = "user_ayment_id")
    @ManyToOne()
    @JoinColumn(
            name = "userId",
            referencedColumnName = "id"
    )
    private UsersEntity userPaymentUser;


    @Column(name = "created_at", nullable = false)
    private Date crestedAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;

    @JsonBackReference(value = "cart_item_product_id")
    @ManyToOne()
    @JoinColumn(
            name = "productId",
            referencedColumnName = "id"
    )
    private ProductsEntity cartItemProductsEntity;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

//    CREATING THE USERS FOREIGN KEY TO THE CREATED BY AND UPDATED BY.

    @JsonBackReference(value = "cart_items_created_by")
    @ManyToOne()
    @JoinColumn(
            name = "crestedBy",
            referencedColumnName = "id"
    )
    private UsersEntity cartItemCreatedByUser;

    @JsonBackReference(value = "cart_items_modified_by")
    @ManyToOne()
    @JoinColumn(
            name = "modifiedBy",
            referencedColumnName = "id"
    )
    private UsersEntity cartItemModifiedByUser;

}
