package com.eatexpress.app.order.adapter.out.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(schema = "ordering", name = "ordered_dishes")
public class OrderedDishJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderedDishId;

    private UUID restaurantId;
    private UUID dishId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderJpaEntity order;

    public OrderedDishJpaEntity() {}

    public OrderedDishJpaEntity(
        Long orderedDishId,
        UUID restaurantId,
        UUID dishId,
        OrderJpaEntity order
    ) {
        this.orderedDishId = orderedDishId;
        this.restaurantId = restaurantId;
        this.dishId = dishId;
        this.order = order;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }

    public Long getOrderedDishId() {
        return orderedDishId;
    }

    public void setOrderedDishId(Long orderedDishId) {
        this.orderedDishId = orderedDishId;
    }

    public OrderJpaEntity getOrder() {
        return order;
    }

    public void setOrder(OrderJpaEntity order) {
        this.order = order;
    }
}
