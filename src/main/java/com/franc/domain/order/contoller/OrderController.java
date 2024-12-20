package com.franc.domain.order.contoller;

import com.franc.domain.order.dto.OrderGetDto;
import com.franc.domain.order.dto.OrderSaveDto;
import com.franc.domain.order.service.OrderFacade;
import com.franc.global.common.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * [주문] Controller (Controller > Facade > Service > Dao)
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderFacade orderFacade;

    @GetMapping("/health_check")
    public ApiResponse<?> status(HttpServletRequest request) throws Exception {
        return ApiResponse.ok("Order Service Ok! - port="+request.getServerPort());
    }

    /**
     * 주문
     * @param userId
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/{userId}")
    public ApiResponse<?> save(
            @PathVariable("userId") @NotBlank String userId,
            @RequestBody @Valid OrderSaveDto.Request request) throws Exception {

        OrderSaveDto.Response response = orderFacade.saveOrder(userId, request);
        return ApiResponse.ok(response);
    }

    /**
     * 주문 조회 - 주문번호
     * @param orderId
     * @return
     * @throws Exception
     */
    @GetMapping("/{orderId}")
    public ApiResponse<?> get(@PathVariable("orderId") @NotBlank String orderId) throws Exception {
        OrderGetDto.Response response = orderFacade.getOrder(orderId);
        return ApiResponse.ok(response);
    }
}
