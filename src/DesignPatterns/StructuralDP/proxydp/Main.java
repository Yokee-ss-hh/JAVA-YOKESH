package org.dsa.structuraldp.proxydp;

public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try{
            internet.connect("make.com");
            internet.connect("hi.com");
        }
        catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }
}
