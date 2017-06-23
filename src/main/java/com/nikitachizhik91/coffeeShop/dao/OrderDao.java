package com.nikitachizhik91.coffeeShop.dao;

import java.util.List;

import com.nikitachizhik91.coffeeShop.model.Order;

public interface OrderDao extends FindAll<Order> {

    Order create(Order order) throws DaoException;

    Order findById(int orderId) throws DaoException;

    List<Order> findOrdersInProcess() throws DaoException;

    Order update(Order order) throws DaoException;

    void delete(int orderId) throws DaoException;
}
