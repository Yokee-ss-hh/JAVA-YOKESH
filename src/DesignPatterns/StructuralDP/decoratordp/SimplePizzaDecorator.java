package org.dsa.structuraldp.decoratordp;

public class SimplePizzaDecorator implements Pizza{
    Pizza pizza;
    public SimplePizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice();
    }
}
