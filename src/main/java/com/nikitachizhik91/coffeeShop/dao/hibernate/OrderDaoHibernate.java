package com.nikitachizhik91.coffeeShop.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikitachizhik91.coffeeShop.dao.DaoException;
import com.nikitachizhik91.coffeeShop.model.Order;

@Repository
public class OrderDaoHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Order> findAll() throws DaoException {
        List<Order> orders = null;
        try (Session session = sessionFactory.openSession()) {
            orders = (List<Order>) session.createQuery("from Order").list();
        }
        return orders;
    }

    public Order create(Order order) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(order);
            session.getTransaction().commit();
            order.setId(id);
        } catch (Exception e) {
            throw new DaoException("Cannot create order=" + order, e);
        }
        return order;
    }

    public Order update(Order order) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Cannot update order=" + order, e);
        }
        return order;
    }

    public void delete(int orderId) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(session.get(Order.class, orderId));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Cannot delete order with id=" + orderId, e);
        }
    }
}
