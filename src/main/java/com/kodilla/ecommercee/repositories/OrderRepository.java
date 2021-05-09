package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
