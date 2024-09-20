package com.pedroneves.apipubsub.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "sku_id", referencedColumnName = "id")
    private Sku sku;

    private BigDecimal quantity;

    private String categoryId;
    private String subCategoryId;

}
