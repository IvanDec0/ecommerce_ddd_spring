package com.ecommerce_learning.ecommerce_learning.domain.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private String orderNumber;
    private Date orderDate;
    private Date orderShippedDate;
    private String orderStatus;
    private double orderTotal;
    private User user;
    private DetailOrder detailOrder;
}
