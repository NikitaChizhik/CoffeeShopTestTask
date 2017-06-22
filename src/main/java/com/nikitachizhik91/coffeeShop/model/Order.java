package com.nikitachizhik91.coffeeShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "orders")
@XmlRootElement
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToOne
    @JoinColumn(name = "sort_of_coffee_id")
    private SortOfCoffee sortOfCoffee;

    @Column(name = "need_of_delivery")
    private boolean needOfDelivery;

    @Column(name = "cost_of_delivery")
    private double costOfDelivery;

    @Column(name = "amount_in_grams")
    private int amountInGrams;

    @OneToOne
    @JoinColumn(name = "time_of_delivery_id")
    private TimeOfDelivery timeOfDelivery;

    @Column(name = "cost_of_order")
    private double costOfOrder;

    @Column(name = "is_done")
    private boolean isDone;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SortOfCoffee getSortOfCoffee() {
        return sortOfCoffee;
    }

    public void setSortOfCoffee(SortOfCoffee sortOfCoffee) {
        this.sortOfCoffee = sortOfCoffee;
    }

    public boolean isNeedOfDelivery() {
        return needOfDelivery;
    }

    public void setNeedOfDelivery(boolean needOfDelivery) {
        this.needOfDelivery = needOfDelivery;
    }

    public double getCostOfDelivery() {
        return costOfDelivery;
    }

    public void setCostOfDelivery(double costOfDelivery) {
        this.costOfDelivery = costOfDelivery;
    }

    public int getAmountInGrams() {
        return amountInGrams;
    }

    public void setAmountInGrams(int amountInGrams) {
        this.amountInGrams = amountInGrams;
    }

    public TimeOfDelivery getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setTimeOfDelivery(TimeOfDelivery timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    public double getCostOfOrder() {
        return costOfOrder;
    }

    public void setCostOfOrder(double costOfOrder) {
        this.costOfOrder = costOfOrder;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amountInGrams;
        long temp;
        temp = Double.doubleToLongBits(costOfDelivery);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(costOfOrder);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + (isDone ? 1231 : 1237);
        result = prime * result + (needOfDelivery ? 1231 : 1237);
        result = prime * result + ((sortOfCoffee == null) ? 0 : sortOfCoffee.hashCode());
        result = prime * result + ((timeOfDelivery == null) ? 0 : timeOfDelivery.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (amountInGrams != other.amountInGrams)
            return false;
        if (Double.doubleToLongBits(costOfDelivery) != Double.doubleToLongBits(other.costOfDelivery))
            return false;
        if (Double.doubleToLongBits(costOfOrder) != Double.doubleToLongBits(other.costOfOrder))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (isDone != other.isDone)
            return false;
        if (needOfDelivery != other.needOfDelivery)
            return false;
        if (sortOfCoffee == null) {
            if (other.sortOfCoffee != null)
                return false;
        } else if (!sortOfCoffee.equals(other.sortOfCoffee))
            return false;
        if (timeOfDelivery == null) {
            if (other.timeOfDelivery != null)
                return false;
        } else if (!timeOfDelivery.equals(other.timeOfDelivery))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", sortOfCoffee=" + sortOfCoffee + ", needOfDelivery=" + needOfDelivery
                + ", costOfDelivery=" + costOfDelivery + ", amountInGrams=" + amountInGrams + ", timeOfDelivery="
                + timeOfDelivery + ", costOfOrder=" + costOfOrder + ", isDone=" + isDone + ", description="
                + description + "]";
    }
}
