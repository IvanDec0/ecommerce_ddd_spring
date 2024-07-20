package com.ecommerce_learning.ecommerce_learning.domain.model;

public enum Roles {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_SELLER;

    public static boolean contains(String typo) {
        for (Roles role : Roles.values()) {
            if (role.name().equals(typo)) {
                return true;
            }
        }
        return false;
    }
}
