package org.dsa.structuraldp.decoratordp;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new SimplePizza("plain type",230.923);
        pizza = new CheesePizzaDecorator(pizza,"cheese",150.54);
        pizza = new PepperoniPizzaDecorator(pizza,"pepperoni",75.7654);
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());
    }
}
