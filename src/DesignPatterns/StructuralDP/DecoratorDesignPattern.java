package DesignPatterns.StructuralDP;

// Adds new behaviors to objects dynamically without altering their structure.
// Offers a flexible alternative to subclassing for extending functionality.
// Component: The interface that defines the standard
// Concrete Component: The basic naked object
// Decorator: The middle man , A box to hold the basic one and the flavored one when used
// Concrete Decorator: The implementation of decorator to pass the toppings on top od concrete component
/*

 WHY DO WE NEED CoffeeDecorator?

 Suppose tomorrow we add new methods to Coffee interface.
 If we do NOT have CoffeeDecorator,
 then every decorator (Milk, Chocolate, etc.)
 must implement and delegate those new methods again.

 That causes duplication.

 CoffeeDecorator solves this by:
 1) Holding the wrapped Coffee object
 2) Providing default delegation
 3) Allowing concrete decorators to override ONLY what they modify

 So if the interface changes,
 we update only CoffeeDecorator,
 not every decorator class.
*/
/*
 CoffeeDecorator prevents duplication by centralizing delegation.
 If Coffee interface changes, only this class needs modification.
 Concrete decorators override only the behavior they want to extend.
*/
interface Coffee {

    String getDescription();
    double getPrice();
    int getCalories();

    // Assume these methods were added later
    boolean isHot();
    String getOrigin();
}

/*
 Concrete Component
 This is the basic object without any decorations.
*/
class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Black Coffee";
    }

    @Override
    public double getPrice() {
        return 45.32;
    }

    @Override
    public int getCalories() {
        return 150;
    }

    @Override
    public boolean isHot() {
        return true;
    }

    @Override
    public String getOrigin() {
        return "Colombia";
    }
}

/*
 This is the IMPORTANT part.

 CoffeeDecorator centralizes delegation logic.

 If new methods are added to Coffee,
 we implement delegation here ONLY ONCE.

 Without this class,
 Milk and Chocolate would be forced to
 implement and delegate every method themselves.
*/
abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    // Default delegation
    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getPrice() {
        return coffee.getPrice();
    }

    @Override
    public int getCalories() {
        return coffee.getCalories();
    }

    // Newly added methods handled here
    @Override
    public boolean isHot() {
        return coffee.isHot();
    }

    @Override
    public String getOrigin() {
        return coffee.getOrigin();
    }
}

/*
 Concrete Decorator

 Notice:
 We only override the methods we want to modify.
 Everything else automatically delegates
 via CoffeeDecorator.

 That is the main benefit.
*/
class Milk extends CoffeeDecorator {

    Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Milk";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 12.34;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 250;
    }

    // We DO NOT need to override:
    // isHot() or getOrigin()
    // because CoffeeDecorator already handles them.
}

/*
 Another Concrete Decorator
*/
class Chocolate extends CoffeeDecorator {

    Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Chocolate";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 30.32;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 200;
    }

    // Again, no need to reimplement other methods.
}

public class DecoratorDesignPattern {

    public static void main(String[] args) {

        // Wrapping dynamically at runtime
        Coffee coffee = new Chocolate(new Milk(new SimpleCoffee()));

        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Calories: " + coffee.getCalories());
        System.out.println("Price: " + coffee.getPrice());
        System.out.println("Is Hot: " + coffee.isHot());
        System.out.println("Origin: " + coffee.getOrigin());
    }
}