package org.dsa.structuraldp.facadedp;

public class CarFacadeImpl implements CarFacade{
    private Engine engine;
    private Steering steering;
    public CarFacadeImpl(Engine engine, Steering steering){
        this.engine = engine;
        this.steering = steering;
    }

    @Override
    public void turnLeft() {
        steering.turnLeft();
    }

    @Override
    public void turnRight() {
        steering.turnRight();
    }

    @Override
    public void startEngine() {
        engine.startEngine();
    }

    @Override
    public void stopEngine() {
        engine.stopEngine();
    }
}
