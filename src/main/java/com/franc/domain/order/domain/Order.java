package com.franc.domain.order.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120, unique=true)
    private String productId;

    @Column(nullable=false)
    private Integer qty;

    @Column(nullable=false)
    private Integer unitPrice;

    @Column(nullable=false)
    @Setter
    private Integer totalPrice;

    @Column(nullable=false)
    @Setter
    private String userId;

    @Column(nullable=false, unique = true)
    @Setter
    private String orderId;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

}
