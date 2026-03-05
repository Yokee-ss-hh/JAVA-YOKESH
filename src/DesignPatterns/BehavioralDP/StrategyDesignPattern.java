package DesignPatterns.BehavioralDP;

// The Strategy Pattern is a behavioral design pattern that lets you define a family of algorithms,
// put each one into a separate class, and make their objects interchangeable at runtime.
// Strategy: A interface with 1 or few method
// Concrete Strategy: Multiple independent classes implementing Strategy referencing as multiple algorithms
// Context: A entry point to tuck in an object at the run time
// Client: The guy who executes all these code

interface PaymentStrategy{
    void pay(float amount);
}
class PayPalStrategy implements PaymentStrategy{
    @Override
    public void pay(float amount) {
        System.out.println("Paying "+amount+" via paypal!!");
    }
}
class StripeStrategy implements PaymentStrategy{
    @Override
    public void pay(float amount) {
        System.out.println("Paying " +amount+" via Stripe!!");
    }
}

// Shopping Cart
class PaymentContext{
    private final PaymentStrategy paymentStrategy;
    PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public void checkOut(float amount){
        paymentStrategy.pay(amount);
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new PayPalStrategy());
        paymentContext.checkOut(3213.31231f);
        PaymentContext paymentContext1 = new PaymentContext(new StripeStrategy());
        paymentContext1.checkOut(8896.312f);
    }
}
