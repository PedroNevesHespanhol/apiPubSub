package com.pedroneves.apipubsub.Repository;

import com.pedroneves.apipubsub.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByCustomerId(Integer customerId);
}
