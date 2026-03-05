package DesignPatterns.BehavioralDP;
// It defines the skeleton (template) of an algorithm in a base class and lets subclasses override
// specific steps without changing the overall algorithm structure.
// Abstract class: Defines a template method and some steps
// Concrete class: Implements few specific steps depending on their behavior and requirement
abstract class Beverage{
    public void makeBeverage(){
        boilWater();
        addLeaves();
        addExtras();
        pourInCup();
    }
    private void boilWater(){
        System.out.println("Boiling Water");
    }

    private void pourInCup(){
        System.out.println("Pouring in the cup");
    }
    abstract void addLeaves();
    abstract void addExtras();
}

// concrete class 1
class Tea extends Beverage{
    @Override
    void addLeaves() {
        System.out.println("Adding tea leaves");
    }

    @Override
    void addExtras() {
        System.out.println("Adding sugar and ginger");
    }
}

// concrete class 2
class Coffee extends Beverage{
    @Override
    void addLeaves() {
        System.out.println("Adding coffee leaves");
    }

    @Override
    void addExtras() {
        System.out.println("Adding small amount of honey");
    }
}

public class TemplateDesignPattern {
    public static void main(String[] args) {
        Beverage teaBeverage = new Tea();
        teaBeverage.makeBeverage();
        Beverage coffeeBeverage = new Coffee();
        coffeeBeverage.makeBeverage();
    }
}
