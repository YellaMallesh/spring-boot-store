package com.FirstProject.Store.mappers;

import com.FirstProject.Store.dtos.CartDto;
import com.FirstProject.Store.dtos.CartItemDto;
import com.FirstProject.Store.entities.Cart;
import com.FirstProject.Store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "items", source = "items")
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice",expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
