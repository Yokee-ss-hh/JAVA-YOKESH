package org.dsa.structuraldp.facadedp;

public class EngineImpl implements Engine{
    @Override
    public void startEngine() {
        System.out.println("starting engine");
    }

    @Override
    public void stopEngine() {
        System.out.println("stopping engine");
    }
}
