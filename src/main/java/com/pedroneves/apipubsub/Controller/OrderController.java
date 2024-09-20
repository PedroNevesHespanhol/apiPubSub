package com.pedroneves.apipubsub.Controller;

import com.pedroneves.apipubsub.Dto.OrderResponse;
import com.pedroneves.apipubsub.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders(
            @RequestParam(required = false) String uuid,
            @RequestParam(required = false) Integer customerId,
            @RequestParam(required = false) String skuId
    ) {
        List<OrderResponse> orders = orderService.getOrders(uuid, customerId, skuId);
        return ResponseEntity.ok(orders);
    }
}

