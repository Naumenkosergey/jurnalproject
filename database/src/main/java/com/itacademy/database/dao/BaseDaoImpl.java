package com.itacademy.database.dao;

import com.itacademy.database.entity.BaseEntity;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Getter
public abstract class BaseDaoImpl<T extends Serializable, E extends BaseEntity<T>> implements BaseDao<T, E> {

    @Autowired
    private SessionFactory sessionFactory;
}
