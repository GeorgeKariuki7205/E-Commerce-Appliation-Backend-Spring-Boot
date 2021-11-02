package com.george_ecommerce.george_ecommerce.OrderItems.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.george_ecommerce.george_ecommerce.OrderDetails.Entity.OrderDetailsEntity;
import com.george_ecommerce.george_ecommerce.Products.Entity.ProductsEntity;
import com.george_ecommerce.george_ecommerce.Users.Entity.UsersEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_order_order_items")
public class OrderItemsEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_order_items",
            sequenceName = "z_sequence_order_items",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_order_items",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long orderItemId;

    @Column(name = "created_at", nullable = false)
    private Date createdAt; 

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;

    @JsonBackReference(value = "order_details_order_item")
    @ManyToOne()
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id"
    )
    private OrderDetailsEntity orderDetailsOrderItemEntity;


    @JsonBackReference(value = "order_details_product_item")
    @ManyToOne()
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private ProductsEntity productsOrderItemEntity;

    //    CREATING THE USERS FOREIGN KEY TO THE CREATED BY AND UPDATED BY.

    @JsonBackReference(value = "order_details_created_by")
    @ManyToOne()
    @JoinColumn(
            name = "crestedBy",
            referencedColumnName = "id"
    )
    private UsersEntity orderDetailsCreatedByUser;

    @JsonBackReference(value = "order_details_modified_by")
    @ManyToOne()
    @JoinColumn(
            name = "modifiedBy",
            referencedColumnName = "id"
    )
    private UsersEntity orderDetailsModifiedByUser;

}
