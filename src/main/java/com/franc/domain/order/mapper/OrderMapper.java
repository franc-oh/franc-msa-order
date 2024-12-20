package com.franc.domain.order.mapper;

import com.franc.domain.order.domain.Order;
import com.franc.domain.order.dto.OrderGetDto;
import com.franc.domain.order.dto.OrderSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order toEntity(OrderSaveDto.Request dto);
    OrderSaveDto.Response toSaveDto(Order entity);

    OrderGetDto.Response toGetDto(Order entity);
}
