package DesignPatterns.StructuralDP;

// Provides a simplified, high-level interface to a complex subsystem, hiding internal complexity and improving usability.
// Subsystem classes: The inner functionalities which are complex
// Facade: The face of the inner sub systems
// Client: Who calls the facade only once which internally calls complex sub systems
class TV{
    public void turnOnTV(){
        System.out.println("Turning On The TV");
    }
    public void turnOffTV(){
        System.out.println("Turning Off The TV");
    }
}

class Light{
    public void turnOnLight(){
        System.out.println("Turning On The Light");
    }
    public void turnOffLight(){
        System.out.println("Turning Off The Light");
    }
}

class AirConditioner{
    public void turnOnAC(){
        System.out.println("Turning On The AC");
    }
    public void turnOffAC(){
        System.out.println("Turning Off The AC");
    }
}

class FacadeMovieTheatre{
    private final TV tv;
    private final Light light;
    private final AirConditioner airConditioner;
    public  FacadeMovieTheatre(TV tv, Light light,AirConditioner airConditioner){
        this.tv=tv;
        this.light=light;
        this.airConditioner=airConditioner;
    }
    public void watchMovie(){
        this.tv.turnOnTV();
        this.light.turnOffLight();
        this.airConditioner.turnOnAC();
    }
}
public class FacadeDesignPattern {
    public static void main(String[] args) {
        FacadeMovieTheatre facadeMovieTheatre = new FacadeMovieTheatre(new TV(),new Light(),new AirConditioner());
        facadeMovieTheatre.watchMovie();
    }
}
