package com.nikitachizhik91.coffeeShop.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nikitachizhik91.coffeeShop.model.Order;
import com.nikitachizhik91.coffeeShop.service.DomainException;
import com.nikitachizhik91.coffeeShop.service.impl.OrderServiceImpl;
import com.nikitachizhik91.coffeeShop.web.WebException;

@Controller
@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderRest {

    @Autowired
    private OrderServiceImpl orderService;

    @GET
    public List<Order> findAll() throws WebException {
        List<Order> orders = null;
        try {
            orders = orderService.findAll();
        } catch (DomainException e) {
            throw new WebException("Cannot find all orders.", e);
        }
        return orders;
    }

    @POST
    public Order create(Order order) throws WebException {
        try {
            order = orderService.create(order);
        } catch (DomainException e) {
            throw new WebException("Cannot create order=" + order, e);
        }
        return order;
    }

    @PUT
    public Order update(Order order) throws WebException {
        try {
            order = orderService.update(order);
        } catch (DomainException e) {
            throw new WebException("Cannot update order=" + order, e);
        }
        return order;
    }

    @DELETE
    @Path("/{orderId}")
    public void delete(@PathParam("orderId") int orderId) throws WebException {
        try {
            orderService.delete(orderId);
        } catch (DomainException e) {
            throw new WebException("Cannot delete order with id=" + orderId, e);
        }
    }
}
