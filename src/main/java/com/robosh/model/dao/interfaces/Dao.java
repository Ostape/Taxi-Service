package com.robosh.model.dao.interfaces;

import java.util.List;

public interface Dao<T> extends AutoCloseable{

       void create(T entity);

        T getById(long id);

        List<T> findAll();

        boolean update(T t);

        boolean delete(long id);

        @Override
        void close();
}
