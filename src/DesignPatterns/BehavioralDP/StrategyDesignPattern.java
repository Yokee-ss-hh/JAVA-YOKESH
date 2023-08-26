package DesignPatterns.BehavioralDP;
// Strategy pattern is a behavioral design pattern that allows the behavior
// of an object to be selected at runtime.
// The Strategy pattern is based on the idea of encapsulating a family of algorithms
// into separate classes that implement a common interface. The pattern consists of three main
// components: the Context, the Strategy, and the Concrete Strategy.
interface Strategy{
    void doOperation(int num1, int num2);
}
class AdditionOperation implements Strategy{
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println(num1+num2);
    }
}
class SubtractionOperation implements Strategy{
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println(num1-num2);
    }
}
class Context{
    private Strategy strategy;
    Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void executeStrategy(int num1, int num2){
        strategy.doOperation(num1,num2);
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        Context context1 = new Context(new AdditionOperation());
        context1.executeStrategy(10,20);

        Context context2 = new Context(new SubtractionOperation());
        context2.executeStrategy(10,20);
    }
}
