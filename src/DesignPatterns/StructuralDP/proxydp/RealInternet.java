package org.dsa.structuraldp.proxydp;

public class RealInternet implements Internet{
    @Override
    public void connect(String hostUrl) {
        System.out.println("Connecting to the host"+hostUrl);
    }
}
