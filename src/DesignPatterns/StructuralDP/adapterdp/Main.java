package org.dsa.structuraldp.adapterdp;

public class Main {
    public static void main(String[] args) {
        PaymentGateway payPalPaymentGateway = new PaypalAdapter(new PaypalImpl());
        PaymentGateway stripePaymentGateway = new StripeAdapter(new StripeImpl());
        payPalPaymentGateway.processPayment(2345.43d);
        stripePaymentGateway.processPayment(52452.3123d);
    }
}
