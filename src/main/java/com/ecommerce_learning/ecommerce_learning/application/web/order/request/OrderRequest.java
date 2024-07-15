package com.ecommerce_learning.ecommerce_learning.application.web.order.request;

import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
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
    private UserResponse user;
    //private DetailOrderDto detailOrder;
}
