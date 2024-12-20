package com.franc.domain.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderSaveDto() {

    /**
     * 요청
     * @param productId
     * @param qty
     * @param unitPrice
     */
    public record Request(
        @NotBlank
        String productId,

        @NotNull
        @Min(1)
        Integer qty,

        @NotNull
        @Min(1)
        Integer unitPrice
    ){}

    /**
     * 응답
     * @param productId
     * @param qty
     * @param unitPrice
     * @param totalPrice
     * @param orderId
     */
    public record Response(
        String productId,
        Integer qty,
        Integer unitPrice,
        Integer totalPrice,
        String orderId
    ){}
}
