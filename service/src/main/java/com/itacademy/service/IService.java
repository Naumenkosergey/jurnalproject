package com.itacademy.service;

import java.util.List;

public interface IService<T> {
    T findUser(int id);

    void saveUser(T user);

    void deleteUser(T user);

    void updateUser(T user);

    List<T> findAllUsers();
}
