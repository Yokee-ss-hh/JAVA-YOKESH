package org.dsa.structuraldp.decoratordp;

public class SimplePizza implements Pizza{
    String description;
    Double price;
    public SimplePizza(String description,Double price){
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
