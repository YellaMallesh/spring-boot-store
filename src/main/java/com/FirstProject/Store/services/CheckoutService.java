package com.FirstProject.Store.services;

import com.FirstProject.Store.dtos.CheckoutRequest;
import com.FirstProject.Store.dtos.CheckoutResponse;
import com.FirstProject.Store.dtos.ErrorDto;
import com.FirstProject.Store.entities.Order;
import com.FirstProject.Store.exceptions.CartEmptyException;
import com.FirstProject.Store.exceptions.CartNotFoundException;
import com.FirstProject.Store.repositories.CartRepository;
import com.FirstProject.Store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckoutService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final CartService cartService;

    public CheckoutResponse checkout(CheckoutRequest request) {
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        if (cart.isEmpty()) {
           throw  new CartEmptyException();
        }

        var order = Order.fromCart(cart,authService.getCurrentUser());

        orderRepository.save(order);
        cartService.clearCart(cart.getId());

        return new CheckoutResponse(order.getId());
    }
}
