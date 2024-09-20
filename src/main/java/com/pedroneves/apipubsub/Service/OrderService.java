package com.pedroneves.apipubsub.Service;

import com.pedroneves.apipubsub.Dto.*;
import com.pedroneves.apipubsub.Model.Order;
import com.pedroneves.apipubsub.Model.OrderItem;
import com.pedroneves.apipubsub.Repository.OrderItemRepository;
import com.pedroneves.apipubsub.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderResponse> getOrders(String orderId, Integer customerId, String skuId) {
        List<Order> orders = orderId != null ?
                List.of(Objects.requireNonNull(orderRepository.findById(orderId).orElse(null))) :
                orderRepository.findByCustomerId(customerId);

        List<OrderResponse> responses = new ArrayList<>();

        for (Order order : orders) {
            List<OrderItem> items = orderItemRepository.findByOrderId(order.getId());
            BigDecimal total = items.stream()
                    .map(item -> item.getSku().getValue().multiply(item.getQuantity()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            List<OrderItemResponse> itemResponses = items.stream().map(item -> new OrderItemResponse(
                    item.getId(),
                    new SkuResponse(item.getSku().getId(), item.getSku().getValue()),
                    item.getQuantity(),
                    new CategoryResponse(item.getCategoryId(), new SubCategoryResponse(item.getSubCategoryId()))
            )).collect(Collectors.toList());

            responses.add(new OrderResponse(
                    order.getId(),
                    order.getCreatedAt(),
                    order.getOrderType(),
                    new CustomerResponse(order.getCustomer().getId(), order.getCustomer().getName()),
                    itemResponses,
                    total
            ));
        }

        return responses;
    }
}
