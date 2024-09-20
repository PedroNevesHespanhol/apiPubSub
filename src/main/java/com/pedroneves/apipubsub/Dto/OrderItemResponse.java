package com.pedroneves.apipubsub.Dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderItemResponse {
    private Integer id;
    private SkuResponse sku;
    private BigDecimal quantity;
    private CategoryResponse category;

}