package DesignPatterns.BehavioralDP;
// The Template Design Pattern is a behavioral design pattern that defines the basic structure
// of an algorithm in a superclass, while allowing subclasses to provide specific implementations
// of certain steps of the algorithm without modifying its overall structure.
// It promotes code reuse and enforces a common algorithm structure across multiple subclasses.
abstract class Cafe{

    // The below 3 methods are private as we are calling them inside the method prepareDrink()
    // which is inside the class itself.
     private void boilWater(){
        System.out.println("Boiling Water");
    }
     private void pourInCup(){
        System.out.println("Pouring in cup");
    }
    private void stir(){
        System.out.println("Stirring drink");
    }
    final void prepareDrink(){
         boilWater();
         addPowder();
         addFluid();
         stir();
         pourInCup();
    }
    abstract void addPowder();
     abstract void addFluid();
}
class Tea extends Cafe{
    @Override
    void addPowder() {
        System.out.println("Adding tea powder");
    }
    @Override
    void addFluid() {
        System.out.println("Adding cow milk");
    }
}
class Coffee extends Cafe{
    @Override
    void addPowder() {
        System.out.println("Adding coffee powder");
    }
    @Override
    void addFluid() {
        System.out.println("Adding buffalo milk");
    }
}
public class TemplateDesignPattern {
    public static void main(String[] args) {
        Cafe tea = new Tea();
        tea.prepareDrink();
        Cafe coffee = new Coffee();
        coffee.prepareDrink();
    }
}
