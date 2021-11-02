package com.george_ecommerce.george_ecommerce.UserAddresses.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.george_ecommerce.george_ecommerce.Users.Entity.UsersEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_users_address")
public class UserAddressesEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_users_addresses",
            sequenceName = "z_sequence_users_addresses",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_users_addresses",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long userAddressId;

    //    ! CREATING THE FOREIGN KEY TO THE USERS TABLE.

    @JsonBackReference(value = "user_payment_id")
    @ManyToOne()
    @JoinColumn(
            name = "userId",
            referencedColumnName = "id"
    )
    private UsersEntity userAddressUser;


    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;

    @Column(name = "address_one", nullable = false)
    private String addressOne;

    @Column(name = "address_two", nullable = false)
    private String addressTwo;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

//    CREATING THE USERS FOREIGN KEY TO THE CREATED BY AND UPDATED BY.

    @JsonBackReference(value = "user_address_created_by")
    @ManyToOne()
    @JoinColumn(
            name = "crestedBy",
            referencedColumnName = "id"
    )
    private UsersEntity userAddressCreatedByUser;

    @JsonBackReference(value = "user_address_modified_by")
    @ManyToOne()
    @JoinColumn(
            name = "modifiedBy",
            referencedColumnName = "id"
    )
    private UsersEntity userAddressModifiedByUser;


}
