package org.dsa.structuraldp.adapterdp;


public class PaypalImpl implements Paypal{
    @Override
    public void makePayment(double amount) {
        System.out.println("Making payment -> paypal"+amount);
    }
}
