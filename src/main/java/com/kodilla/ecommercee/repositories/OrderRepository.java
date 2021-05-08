package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    Order save(final Order order);

    @Override
    Optional<Order> findById(final Long id);

    @Override
    void deleteById(final Long id);

}
