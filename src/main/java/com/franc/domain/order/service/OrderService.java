package com.franc.domain.order.service;

import com.franc.domain.order.domain.Order;
import com.franc.domain.order.repository.OrderRepository;
import com.franc.global.error.BizException;
import com.franc.global.error.ErrorCode;
import com.franc.global.util.FrancUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

/**
 * [주문] Service (Controller > Facade > Service > Repository)
 * - 해당 도메인의 개별 기능구현
 *      - 쿼리호출
 *      - 데이터 가공
 *      - 재사용
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    /**
     * 주문
     * @param order
     * @return
     * @throws Exception
     */
    public Order saveOrder(Order order) throws Exception {
        FrancUtil.isNullThrowBizException(order, ErrorCode.ORDER_FAIL_ARGUMENT_NOT_VALID);

        if(!StringUtils.hasText(order.getProductId())
                || Objects.isNull(order.getQty()) || Objects.isNull(order.getUnitPrice())) {
            throw new BizException(ErrorCode.ORDER_FAIL_ARGUMENT_NOT_VALID);
        }

        // 주문 총액 구하기
        int totalPrice = order.getUnitPrice() * order.getQty();
        order.setTotalPrice(totalPrice);

        // 주문번호 생성
        String orderId = UUID.randomUUID().toString();
        order.setOrderId(orderId);

        return orderRepository.save(order);
    }

    public Order findOrderByOrderId(String orderId) throws Exception {
        return orderRepository.findByOrderId(orderId);
    }
}
