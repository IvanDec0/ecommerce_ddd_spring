package com.ecommerce_learning.ecommerce_learning.shared.util;

public class ReturnConstants {

    public static final String ORDER_NOT_FOUND = "Order with id %s not found";
    public static final String ORDER_NUMBER_EXISTS = "Order with order number %s already exists";
    public static final String PRODUCT_NOT_FOUND = "Product with id %s not found";
    public static final String PRODUCT_ID_EXISTS = "Product with id %s already exists";
    public static final String PRODUCT_NAME_EXISTS = "Product with name %s already exists";
    public static final String DETAIL_ORDER_ID_MUST_BE_NULL = "Detail Order id must be null";
    public static final String DETAIL_ORDER_NOT_FOUND = "Detail Order with id %s not found";
    public static final String DETAIL_ORDER_EXISTS = "Detail Order with order number %s already exists";
    public static final String ORDER_NUMBER_NOT_FOUND = "Detail Order with order number %s not found";
    public static final String ORDER_NOT_FOUND_BY_ID = "Order with id %s not found";
    public static final String ORDER_NOT_FOUND_BY_ORDER_NUMBER = "Order with order number %s not found";
    public static final String ORDER_NOT_FOUND_BY_USER_ID = "Order with user id %s not found";
    public static final String USER_NOT_FOUND_BY_ID = "User with id %s not found";
    public static final String USER_EMAIL_EXISTS = "User with email %s already exists";
    public static final String USER_NOT_FOUND_BY_EMAIL = "User with email %s not found";
    public static final String USER_NOT_FOUND_BY_EMAIL_AND_PASSWORD = "User with email %s and password %s not found";
    public static final String USER_NOT_FOUND_BY_EMAIL_AND_PASSWORD_AND_ROLE = "User with email %s and password %s and role %s not found";
    public static final String USER_NOT_FOUND_BY_EMAIL_AND_ROLE = "User with email %s and role %s not found";
    public static final String USER_NOT_FOUND_BY_ROLE = "User with role %s not found";
    public static final String USER_NOT_FOUND_BY_EMAIL_AND_PASSWORD_AND_ROLE_AND_STATUS = "User with email %s and password %s and role %s and status %s not found";
    public static final String USER_NOT_FOUND_BY_EMAIL_AND_ROLE_AND_STATUS = "User with email %s and role %s and status %s not found";
    public static final String USER_NOT_FOUND_BY_ROLE_AND_STATUS = "User with role %s and status %s not found";
    public static final String USER_NOT_FOUND_BY_STATUS = "User with status %s not found";
    public static final String USER_NOT_FOUND_BY_EMAIL_AND_STATUS = "User with email %s and status %s not found";

    // Private constructor to hide the implicit public one
    private ReturnConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
