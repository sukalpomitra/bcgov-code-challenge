package com.innofyre.rhcfs.controller;

import com.innofyre.rhcfs.model.OrderDiscount;
import com.innofyre.rhcfs.model.OrderRequest;
import com.innofyre.rhcfs.service.OrderDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * This is only for testing and not need for the code challenge
 * I implemented this to test the rule engine
 *
 * TODO: Remove this Order related codes when delivering the code challenge.
 */
@RestController
@RequiredArgsConstructor
public class OrderDiscountController {

    private final OrderDiscountService orderDiscountService;

    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }


}