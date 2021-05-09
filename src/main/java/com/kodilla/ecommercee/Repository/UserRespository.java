package com.kodilla.ecommercee.Repository;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User, Long> {
}
