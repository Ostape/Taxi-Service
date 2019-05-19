package com.robosh.model.dao;

import java.util.List;

public interface Dao<T> extends AutoCloseable{
        //Create
        void create(T entity);

        //Read
        T getById(long id);

        List<T> findAll();

        //Update
        void update(T t);

        //Delete
        void delete(long id);

        //Close
        void close();
}
