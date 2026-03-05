package DesignPatterns.StructuralDP;
// Subject: A interface which says the functionality
// Real Subject: A class implementing subject which has a real functionality
// Proxy: A class that calls Real Subject, but it does some operations before that
// Client: A class which calls the proxy

import java.util.List;

interface Internet{
    void surfInternet(String website) throws Exception;
}
class RealInternet implements Internet{
    @Override
    public void surfInternet(String website){
        System.out.println("Accessing "+website);
    }
}
class ProxyInternet implements Internet{
    private static final Internet realInternet = new RealInternet();
    private final List<String> blockedWebsites = List.of("abc.com","xyz.com");
    @Override
    public void surfInternet(String website) throws Exception {
        if(blockedWebsites.contains(website)){
            throw new Exception("This website is not allowed to surf!!!");
        }
        realInternet.surfInternet(website);
    }
}
public class ProxyDesignPattern {
    public static void main(String[] args) throws Exception {
        ProxyInternet proxyInternet = new ProxyInternet();
        proxyInternet.surfInternet("yokesh.com");
        proxyInternet.surfInternet("abc.com");
    }
}
