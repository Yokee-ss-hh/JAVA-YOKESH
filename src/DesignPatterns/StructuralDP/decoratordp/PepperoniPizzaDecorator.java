package org.dsa.structuraldp.decoratordp;

public class PepperoniPizzaDecorator implements Pizza{
    Pizza pizza;
    String description;
    Double price;
    public PepperoniPizzaDecorator(Pizza pizza,String description,Double price){
        this.pizza = pizza;
        this.description = description;
        this.price = price;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" added"+this.description;
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice()+this.price;
    }
}
