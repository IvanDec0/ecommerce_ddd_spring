package com.ecommerce_learning.ecommerce_learning.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUser {

        private String email;
        private String password;
}
