package org.dsa.structuraldp.adapterdp;

public class StripeImpl implements Stripe{
    @Override
    public void doPayment(double amount) {
        System.out.println("Making payment -> stripe"+amount);
    }
}
