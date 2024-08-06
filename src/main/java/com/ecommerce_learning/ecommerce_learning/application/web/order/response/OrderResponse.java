package com.ecommerce_learning.ecommerce_learning.application.web.order.response;

import com.ecommerce_learning.ecommerce_learning.application.web.detail_order.response.DetailOrderResponse;
import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private String id;
    private String orderNumber;
    private Date orderDate;
    private Date orderShippedDate;
    private String orderStatus;
    private double orderTotal;
    private UserResponse user;
    private DetailOrderResponse detailOrder;
}
