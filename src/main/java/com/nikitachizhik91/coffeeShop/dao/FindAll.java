package com.nikitachizhik91.coffeeShop.dao;

import java.util.List;

public interface FindAll<T> {

    // T create(T entity) throws DaoException;

    // T findById(int id) throws DaoException;

    List<T> findAll() throws DaoException;

    // T update(T entity) throws DaoException;

    // void delete(int id) throws DaoException;
}
