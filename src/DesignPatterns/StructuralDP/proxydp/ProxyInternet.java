package org.dsa.structuraldp.proxydp;

import org.dsa.structuraldp.proxydp.Internet;

import java.util.List;

public class ProxyInternet implements Internet {
    private List<String> bannedUrls = List.of("hello.com","hi.com","howareyou.com");
    private Internet realInternet = new RealInternet();
    @Override
    public void connect(String hostUrl) throws IllegalAccessException {
        if(bannedUrls.contains(hostUrl)){
            throw new IllegalAccessException("Cannot connect to "+hostUrl+" : website restricted !!");
        }
        realInternet.connect(hostUrl);
    }
}
