package com.nikitachizhik91.coffeeShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikitachizhik91.coffeeShop.dao.DaoException;
import com.nikitachizhik91.coffeeShop.dao.SortOfCoffeeDao;
import com.nikitachizhik91.coffeeShop.model.SortOfCoffee;
import com.nikitachizhik91.coffeeShop.service.DomainException;
import com.nikitachizhik91.coffeeShop.service.SortOfCoffeeService;

@Service
public class SortOfCoffeeServiceImpl implements SortOfCoffeeService {

    @Autowired
    private SortOfCoffeeDao sortOfCoffeeDao;

    public List<SortOfCoffee> findAll() throws DomainException {
        List<SortOfCoffee> sortOfCoffees = null;
        try {
            sortOfCoffees = sortOfCoffeeDao.findAll();
        } catch (DaoException e) {
            throw new DomainException("Cannot find all sorts of coffee.", e);
        }
        return sortOfCoffees;
    }
}
