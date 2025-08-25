package com.FirstProject.Store.mappers;

import com.FirstProject.Store.dtos.OrderDto;
import com.FirstProject.Store.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
