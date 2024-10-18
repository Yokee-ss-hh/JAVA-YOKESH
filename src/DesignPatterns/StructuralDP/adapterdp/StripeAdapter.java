package org.dsa.structuraldp.adapterdp;

public class StripeAdapter implements PaymentGateway{
    private Stripe stripe;
    public StripeAdapter(Stripe stripe){
        this.stripe=stripe;
    }
    @Override
    public void processPayment(double amount) {
        stripe.doPayment(amount);
    }
}
