package com.nikitachizhik91.coffeeShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikitachizhik91.coffeeShop.dao.DaoException;
import com.nikitachizhik91.coffeeShop.dao.hibernate.OrderDaoHibernate;
import com.nikitachizhik91.coffeeShop.model.Order;
import com.nikitachizhik91.coffeeShop.service.DomainException;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderDaoHibernate orderDao;

    public List<Order> findAll() throws DomainException {
        List<Order> orders = null;
        try {
            orders = orderDao.findAll();
        } catch (DaoException e) {
            throw new DomainException("Cannot find all orders.", e);
        }
        return orders;
    }

    public Order create(Order order) throws DomainException {
        if (order.getAmountInGrams() < 100) {
            throw new IllegalArgumentException("You can't order less than 100 grams.");
        }
        long startTime = order.getTimeOfDelivery().getEndTime().getTimeInMillis();
        long endTime = order.getTimeOfDelivery().getStartTime().getTimeInMillis();
        if (endTime > startTime) {
            throw new IllegalArgumentException("EndTime=" + endTime + " is less than startTime=" + startTime);
        }
        Order orderTemp = null;
        try {
            orderTemp = orderDao.create(order);
        } catch (DaoException e) {
            throw new DomainException("Cannot create order=" + order, e);
        }
        return orderTemp;
    }

    public Order update(Order order) throws DomainException {
        Order lessonTemp = null;
        try {
            lessonTemp = orderDao.update(order);
        } catch (DaoException e) {
            throw new DomainException("Cannot update order=" + order, e);
        }
        return lessonTemp;
    }

    public void delete(int orderId) throws DomainException {
        try {
            orderDao.delete(orderId);
        } catch (DaoException e) {
            throw new DomainException("Cannot delete order with id=" + orderId, e);
        }
    }
}
