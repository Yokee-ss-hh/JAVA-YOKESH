package DesignPatterns.StructuralDP;
// Facade design pattern simplifies the interaction between client and multiple complex subsystems through
// a simple interface
// If there are 12 functionalities that client wants and these 12 are implemented under 3 classes in which
// each class implements 4 functionalities
// Then client gets confusion every time which class object should create to call required specific functionality method.
// So, We can provide a simple interface with all 12 functionalities so that client can create a single object
// without confusion to call required functionality.
interface Engine{
    void start();
    void stop();
}
interface Gear{
    void gearUp();
    void gearDown();
}
interface Steering{
    void turnLeft();
    void turnRight();
}
class EngineImpl implements Engine{
    @Override
    public void start() {
        System.out.println("Engine Started");
    }
    @Override
    public void stop() {
        System.out.println("Engine Stopped");
    }
}
class GearImpl implements Gear{
    @Override
    public void gearUp() {
        System.out.println("Gear changed to up");
    }
    @Override
    public void gearDown() {
        System.out.println("Gear changed to down");
    }
}
class SteeringImpl implements Steering{
    @Override
    public void turnLeft() {
        System.out.println("Steering turned left");
    }
    @Override
    public void turnRight() {
        System.out.println("Steering turned right");
    }
}
interface Vehicle{
    void start();
    void stop();
    void gearUp();
    void gearDown();
    void turnLeft();
    void turnRight();
}
class VehicleImpl implements Vehicle{
    private Engine engine;
    private Gear gear;
    private Steering steering;
    public VehicleImpl(){
        this.engine = new EngineImpl();
        this.gear = new GearImpl();
        this.steering = new SteeringImpl();
    }
    @Override
    public void start() {
        engine.start();
    }
    @Override
    public void stop() {
        engine.stop();
    }
    @Override
    public void gearUp() {
        gear.gearUp();
    }
    @Override
    public void gearDown() {
        gear.gearDown();
    }
    @Override
    public void turnLeft() {
        steering.turnLeft();
    }
    @Override
    public void turnRight() {
        steering.turnRight();
    }
}
public class FacadeDesignPattern {
    public static void main(String[] args) {
        Vehicle vehicle = new VehicleImpl();
        vehicle.start();
        vehicle.gearUp();
        vehicle.turnLeft();
        vehicle.turnRight();
        vehicle.gearDown();
        vehicle.stop();
    }
}
