package DesignPatterns.BehavioralDP;
// Mediator Pattern is a behavioral design pattern that reduces direct dependencies between objects by introducing a mediator object.
// Mediator: A interface with mediating methods
// Concrete Mediator: A class implementing Mediator
// Colleague: A abstract class defining how participants looks like
// Concrete Colleagues: A group of classes extending Colleague behavior

interface AirControlTower{
    void requestLanding(Flight flight);
}

class AirportTrafficTower implements AirControlTower{
    private boolean runwayAvailable = true;
    @Override
    public void requestLanding(Flight flight) {

        if (runwayAvailable) {
            System.out.println("Runway available. Landing permitted for " + flight.getName());
            runwayAvailable = false;
        } else {
            System.out.println("Runway busy. " + flight.getName() + " please wait.");
        }
    }
    public void freeRunway() {
        runwayAvailable = true;
        System.out.println("Runway is now free.");
    }
}

abstract class Flight{
    protected AirControlTower airControlTower;
    protected String name;
    public String getName() {
        return name;
    }
    Flight(AirControlTower airControlTower, String name){
        this.airControlTower=airControlTower;
        this.name=name;
    }
    public abstract void requestLanding();
}

class ConsumerFlight extends Flight{
    public ConsumerFlight(AirportTrafficTower att, String name) {
        super(att, name);
    }
    @Override
    public void requestLanding() {
        airControlTower.requestLanding(this);
    }
}

class CarrierFlight extends Flight {
    public CarrierFlight(AirportTrafficTower att, String name) {
        super(att, name);
    }
    @Override
    public void requestLanding() {
        airControlTower.requestLanding(this);
    }
}

public class MediatorDesignPattern {
    public static void main(String[] args) {
        AirportTrafficTower airportTrafficTower = new AirportTrafficTower();
        Flight consumerFlight = new CarrierFlight(airportTrafficTower,"X92JAR");
        Flight carrierFlight = new CarrierFlight(airportTrafficTower,"IU908ZX");
        consumerFlight.requestLanding();
        carrierFlight.requestLanding();
        airportTrafficTower.freeRunway();
        carrierFlight.requestLanding();
    }
}
