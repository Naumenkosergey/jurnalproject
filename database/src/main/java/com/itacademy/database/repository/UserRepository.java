package com.itacademy.database.repository;

import com.itacademy.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Override
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(Long id);

    @Override
    Iterable<User> findAll();

    //    Optional<User> findAllUser();
}
