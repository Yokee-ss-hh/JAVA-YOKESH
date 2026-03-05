package DesignPatterns.BehavioralDP;

// Passes a request along a chain of handlers; each handler decides whether to process it or pass it to the next handler
// Handler: A abstract class defining core logic
// Concrete Handlers: The classes which dispatches the request to their colleagues
// Client: A class who initiate the request

abstract class Approver{
    protected Approver nextApprover;
    public void setNextApprover(Approver nextApprover){
        this.nextApprover=nextApprover;
    }
    public abstract void approve(double amount);
}

class Manager extends Approver{
    @Override
    public void approve(double amount) {
        if (amount <= 10000) {
            System.out.println("Team Lead approved " + amount);
        } else if (nextApprover != null) {
            nextApprover.approve(amount);
        }
    }
}

class Director extends Approver{
    @Override
    public void approve(double amount) {
        if (amount <= 50000) {
            System.out.println("Manager approved " + amount);
        } else if (nextApprover != null) {
            nextApprover.approve(amount);
        }
    }
}

public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        manager.setNextApprover(director);
        manager.approve(10000);
        manager.approve(50000);
    }
}
