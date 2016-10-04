package me.jetmoney.dao;


import me.jetmoney.entity.BaseEntity;

/**
 * Created by Denis Murzin
 *      on 26.09.16.
 */

public interface BaseDAO<T extends BaseEntity> {

    T findByID(Long id);

    void save(T model);

    void update(T model);

}
