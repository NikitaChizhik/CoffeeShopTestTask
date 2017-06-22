package com.nikitachizhik91.coffeeShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikitachizhik91.coffeeShop.dao.DaoException;
import com.nikitachizhik91.coffeeShop.dao.hibernate.SortOfCoffeeDaoHibernate;
import com.nikitachizhik91.coffeeShop.model.SortOfCoffee;
import com.nikitachizhik91.coffeeShop.service.DomainException;

@Service
public class SortOfCoffeeServiceImpl {

    @Autowired
    private SortOfCoffeeDaoHibernate coffeeDao;

    public List<SortOfCoffee> findAll() throws DomainException {
        List<SortOfCoffee> sortOfCoffees = null;
        try {
            sortOfCoffees = coffeeDao.findAll();
        } catch (DaoException e) {
            throw new DomainException("Cannot find all coffees.", e);
        }
        return sortOfCoffees;
    }
}
