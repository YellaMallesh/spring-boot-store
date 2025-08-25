package com.FirstProject.Store.controller;

import com.FirstProject.Store.dtos.CheckoutRequest;
import com.FirstProject.Store.dtos.CheckoutResponse;
import com.FirstProject.Store.dtos.ErrorDto;
import com.FirstProject.Store.exceptions.CartEmptyException;
import com.FirstProject.Store.exceptions.CartNotFoundException;
import com.FirstProject.Store.services.CheckoutService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping
    public CheckoutResponse checkout(@Valid @RequestBody CheckoutRequest request) {
    return checkoutService.checkout(request);
    }

    @ExceptionHandler({CartNotFoundException.class, CartEmptyException.class})
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        return  ResponseEntity.badRequest().body(new ErrorDto(e.getMessage()));
    }
}
