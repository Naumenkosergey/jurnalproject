package com.itacademy.database.dao;

import com.itacademy.database.entity.BaseEntity;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends Serializable, E extends BaseEntity<T>> {

    SessionFactory getSessionFactory();

    default Class<E> getClazz() {
        return (Class<E>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[1];
    }

    default Optional<E> get(T id) {
        return Optional.ofNullable(getSessionFactory().getCurrentSession().get(getClazz(), id));
    }

    default void delete(E entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    default E findById(T id) {
        @Cleanup Session session = getSessionFactory().getCurrentSession();
        return session.get(getClazz(), id);

    }

    default T save(E entity) {
        getSessionFactory().getCurrentSession().save(entity);
        return entity.getId();
    }

    default void update(E entity) {
        getSessionFactory().getCurrentSession().update(entity);
    }

    default List<E> findAll() {
        CriteriaBuilder criteriaBuilder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<E> criteria = criteriaBuilder.createQuery(getClazz());
        Root<E> root = criteria.from(getClazz());
        criteria.select(root);
        return getSessionFactory().getCurrentSession().createQuery(criteria).list();
    }
}
