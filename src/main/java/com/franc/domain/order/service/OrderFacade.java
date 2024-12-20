package com.franc.domain.order.service;

import com.franc.domain.order.domain.Order;
import com.franc.domain.order.dto.OrderGetDto;
import com.franc.domain.order.dto.OrderSaveDto;
import com.franc.domain.order.mapper.OrderMapper;
import com.franc.global.error.ErrorCode;
import com.franc.global.util.FrancUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * [주문] Facade (Controller > Facade > Service > Repository)
 *  - 하나의 엔드포인트에 대한 비즈니스로직을 담당
 *      - Service의 개별 기능들을 조립 > 비즈니스 로직을 구현
 *      - Transaction 설정
 */

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private static final Logger logger = LoggerFactory.getLogger(OrderFacade.class);

    private final OrderService orderService;

    private final OrderMapper orderMapper;


    /**
     * 주문
     * @param userId
     * @param request
     * @return
     * @throws Exception
     */
    public OrderSaveDto.Response saveOrder(String userId, OrderSaveDto.Request request) throws Exception {
        Order order = orderMapper.toEntity(request);
        order.setUserId(userId);

        return orderMapper.toSaveDto(orderService.saveOrder(order));
    }

    /**
     * 주문 조회
     * @param orderId
     * @return
     * @throws Exception
     */
    public OrderGetDto.Response getOrder(String orderId) throws Exception {
        Order order = FrancUtil.isNullThrowBizException(orderService.findOrderByOrderId(orderId), ErrorCode.ORDER_NOT_FOUND);
        return orderMapper.toGetDto(order);
    }

}
