package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.UserNotExist;
import com.kodilla.ecommercee.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDbService {

    private final UserRepository repository;

    public void saveUser (final User user) {
        repository.save(user);
    }

    public Optional<User> findUserById (final Long id) {
        return repository.findById(id);
    }

    public void deleteById (final Long id) {
        repository.deleteById(id);
    }

    public long count () {
        return repository.count();
    }
}
