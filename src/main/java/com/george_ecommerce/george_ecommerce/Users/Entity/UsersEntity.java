package com.george_ecommerce.george_ecommerce.Users.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.george_ecommerce.george_ecommerce.CartItems.Entity.CartItemsEntity;
import com.george_ecommerce.george_ecommerce.OrderDetails.Entity.OrderDetailsEntity;
import com.george_ecommerce.george_ecommerce.UserAddresses.Entity.UserAddressesEntity;
import com.george_ecommerce.george_ecommerce.UserPayments.Entity.UserPaymentsEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_users_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UsersEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_users_users",
            sequenceName = "z_sequence_users_users",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_users_users",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    //    CREATING THE RELATIONSHIP TO THE USERS TABLE.
    @JsonManagedReference(value = "user_payment_id")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "userPaymentUser"
    )
    private List<UserPaymentsEntity> userPaymentsEntities;


    @JsonManagedReference(value = "cart_items_created_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "cartItemCreatedByUser"
    )
    private List<CartItemsEntity> cartItemCreatedByUser;

    @JsonManagedReference(value = "cart_items_modified_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "cartItemModifiedByUser"
    )
    private List<CartItemsEntity> cartItemModifiedByUser;


    @JsonManagedReference(value = "user_payment_created_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "createdByUser"
    )
    private List<UserPaymentsEntity> userPaymentsCreatedBy;

    @JsonManagedReference(value = "user_payment_modified_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "modifiedByUser"
    )
    private List<UserPaymentsEntity> userPaymentsModifiedBy;




    //    CREATING THE RELATIONSHIP TO THE USERS TABLE.
    @JsonManagedReference(value = "user_payment_id")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "userAddressUser"
    )
    private List<UserAddressesEntity> userAddressesEntities;

    @JsonManagedReference(value = "user_address_created_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "userAddressCreatedByUser"
    )
    private List<UserAddressesEntity> userAddressCreatedByUser;

    @JsonManagedReference(value = "user_address_modified_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "userAddressModifiedByUser"
    )
    private List<UserAddressesEntity> userAddressModifiedByUser;

    @JsonManagedReference(value = "order_details_user_id")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "orderDetailsUser"
    )
    private List<OrderDetailsEntity> orderDetailsUser;

    @JsonManagedReference(value = "order_details_created_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "orderDetailsCreatedByUser"
    )
    private List<OrderDetailsEntity> orderDetailsEntitiesCreatedByUser;

    @JsonManagedReference(value = "order_details_modified_by")
    @OneToMany(
            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "orderDetailsModifiedByUser"
    )
    private List<OrderDetailsEntity> orderDetailsEntitiesModifiedByUser;


    public UsersEntity(
            String firstName,
            String lastName,
            String emailAddress,
            String password,
            String telephoneNumber,
            Date createdAt,
            Long createdBy

    ) {

        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.telephoneNumber = telephoneNumber;

    }

    public UsersEntity(
            String firstName,
            String lastName,
            String emailAddress,
            String password,
            String telephoneNumber,
            Date updatedAt,
            Long updatedBy,
            Long userId

    ) {

        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.telephoneNumber = telephoneNumber;

    }
}
