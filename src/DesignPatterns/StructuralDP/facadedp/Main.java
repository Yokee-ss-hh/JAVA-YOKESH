package org.dsa.structuraldp.facadedp;

public class Main {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacadeImpl(new EngineImpl(),new SteeringImpl());
        carFacade.startEngine();
        carFacade.stopEngine();
        carFacade.turnLeft();
        carFacade.turnRight();
    }
}
