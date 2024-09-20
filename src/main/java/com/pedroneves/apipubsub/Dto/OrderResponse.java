package com.pedroneves.apipubsub.Dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderResponse {
    private String uuid;
    private String createdAt;
    private String type;
    private CustomerResponse customer;
    private List<OrderItemResponse> items;
    private BigDecimal total;
}