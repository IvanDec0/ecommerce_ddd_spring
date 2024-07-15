package com.ecommerce_learning.ecommerce_learning.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String orderNumber;
    private Date orderDate;
    private Date orderShippedDate;
    private String orderStatus;
    private double orderTotal;

    @DBRef
    private UserDB user;

    @DBRef
    private DetailOrderDB detailOrder;

}
