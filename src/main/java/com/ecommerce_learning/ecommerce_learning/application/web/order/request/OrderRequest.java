package com.ecommerce_learning.ecommerce_learning.application.web.order.request;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String orderNumber;
    private Date orderDate;
    private Date orderShippedDate;
    private String orderStatus;
    private double orderTotal;
    private String user;
    //private DetailOrderDto detailOrder;
}
