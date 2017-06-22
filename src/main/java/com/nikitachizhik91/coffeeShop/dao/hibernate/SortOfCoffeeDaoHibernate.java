package com.nikitachizhik91.coffeeShop.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikitachizhik91.coffeeShop.dao.DaoException;
import com.nikitachizhik91.coffeeShop.model.SortOfCoffee;

@Repository
public class SortOfCoffeeDaoHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<SortOfCoffee> findAll() throws DaoException {
        List<SortOfCoffee> sortOfCoffees = null;
        try (Session session = sessionFactory.openSession()) {
            sortOfCoffees = (List<SortOfCoffee>) session.createQuery("from SortOfCoffee").list();
        }
        return sortOfCoffees;
    }
}
