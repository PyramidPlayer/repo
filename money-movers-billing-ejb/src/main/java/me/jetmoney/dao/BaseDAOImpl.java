package me.jetmoney.dao;

import me.jetmoney.entity.BaseEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;


/**
 * Created by Denis Murzin
 *      on 26.09.16.
 */

@Stateless
public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    @Inject
    private EntityManager entityManager;

    @Override
    public T findByID(Long id) {
        return entityManager.find(getGenericClass(), id);
    }

    @Override
    public void save(T model) {
        entityManager.persist(model);
    }

    @Override
    public void update(T model) {
        entityManager.merge(model);
    }

    protected Class<T> getGenericClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected String getGenericClassName() {
        return getGenericClass().getName();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
