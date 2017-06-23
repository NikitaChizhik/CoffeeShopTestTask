package com.nikitachizhik91.coffeeShop.service;

import java.util.List;

import com.nikitachizhik91.coffeeShop.model.SortOfCoffee;

public interface SortOfCoffeeService {

    List<SortOfCoffee> findAll() throws DomainException;
}
