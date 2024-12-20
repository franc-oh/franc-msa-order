package com.franc.domain.order.dto;

import java.time.LocalDateTime;

public record OrderGetDto() {

    /**
     * 응답
     * @param orderId
     * @param productId
     * @param qty
     * @param unitPrice
     * @param totalPrice
     * @param createdAt
     */
    public record Response(
       String orderId,
       String productId,
       Integer qty,
       Integer unitPrice,
       Integer totalPrice,
       LocalDateTime createdAt
    ) {}
}
