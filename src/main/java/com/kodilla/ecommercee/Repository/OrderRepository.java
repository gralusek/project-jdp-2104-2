package com.kodilla.ecommercee.Repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository <Order, Long> {
}
