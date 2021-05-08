package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    User save(final User user);

    @Override
    Optional<User> findById(final Long id);

    @Override
    void deleteById(final Long id);

}
