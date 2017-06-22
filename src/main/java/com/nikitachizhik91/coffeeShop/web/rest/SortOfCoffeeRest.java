package com.nikitachizhik91.coffeeShop.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nikitachizhik91.coffeeShop.model.SortOfCoffee;
import com.nikitachizhik91.coffeeShop.service.DomainException;
import com.nikitachizhik91.coffeeShop.service.impl.SortOfCoffeeServiceImpl;
import com.nikitachizhik91.coffeeShop.web.WebException;

@Controller
@Path("/coffee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SortOfCoffeeRest {

    @Autowired
    private SortOfCoffeeServiceImpl coffeeService;

    @GET
    public List<SortOfCoffee> findAll() throws WebException {
        List<SortOfCoffee> sortOfCoffees = null;
        try {
            sortOfCoffees = coffeeService.findAll();

        } catch (DomainException e) {
            throw new WebException("Cannot find all coffees.", e);
        }
        return sortOfCoffees;
    }
}
