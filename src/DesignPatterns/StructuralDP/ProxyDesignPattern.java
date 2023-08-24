package DesignPatterns.StructuralDP;

import java.util.ArrayList;
import java.util.List;
// Proxy pattern is used when we need to create a wrapper to cover the main object’s complexity from the client.
interface Internet{
    void connect(String serverHost) throws Exception;
}
class RealInternet implements Internet{
    @Override
    public void connect(String serverHost) {
        System.out.println(String.format("Connecting to %s ",serverHost));
    }
}
class ProxyInternet implements Internet{
    private Internet internet = new RealInternet();
    private static List<String> restrictedWebSites;
    static {
        restrictedWebSites = new ArrayList<>();
        restrictedWebSites.add("gotoschool.com");
        restrictedWebSites.add("yotube.com");
    }
    @Override
    public void connect(String serverHost) throws Exception{
        if(restrictedWebSites.contains(serverHost)){
            throw new IllegalAccessException(String.format("The host %s is not accessible",serverHost));
        }
        internet.connect(serverHost);
    }
}

public class ProxyDesignPattern {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try{
            internet.connect("google.com");
            internet.connect("gotoschool.com");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
