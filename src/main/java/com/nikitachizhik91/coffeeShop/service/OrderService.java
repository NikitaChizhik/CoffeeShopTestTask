package com.nikitachizhik91.coffeeShop.service;

import java.util.List;

import com.nikitachizhik91.coffeeShop.model.Order;

public interface OrderService {

    List<Order> findAll() throws DomainException;

    List<Order> findOrdersInProcess() throws DomainException;

    Order create(Order order) throws DomainException;

    Order update(Order order) throws DomainException;

    Order updateStatus(int orderId, boolean isDone) throws DomainException;

    void delete(int orderId) throws DomainException;
}
