package com.itacademy.database.dao;

import com.itacademy.database.entity.BaseEntity;
import com.itacademy.database.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends Serializable, E extends BaseEntity<T>> {

    @SuppressWarnings("unchecked")
    default Class<E> getClazz() {
        Type entityType = ((ParameterizedType) getClass().getGenericInterfaces()[0])
                .getActualTypeArguments()[1];
        return (Class<E>) entityType;
    }

    default Optional<E> get(T id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return Optional.ofNullable(session.get(getClazz(),id));
    }

    default E findById(T id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .get(getClazz(),id);

    }

    default T save(E entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        return entity.getId();
    }

    default void update(E entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
//        session.close();
    }

    default void delete(E entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.delete(entity);
        transaction.commit();
//        session.close();

    }

    default List<E> findAll() {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Class<E> clazz = getClazz();
//        List<E> entites = (List<E>) session.createQuery(String.format("select u from %s u", clazz.getSimpleName()), clazz).list();
//        return entites;

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Class<E>clazz = getClazz();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<E> criteria = criteriaBuilder.createQuery(getClazz());
        Root<E> root = criteria.from(getClazz());
        criteria.select(root);
        return session.createQuery(criteria).list();

    }
}
