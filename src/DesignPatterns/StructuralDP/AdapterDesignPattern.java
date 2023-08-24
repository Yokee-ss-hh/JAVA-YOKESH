package DesignPatterns.StructuralDP;
// Adapter design pattern is one of the structural design pattern and its used so that two unrelated
// interfaces can work together. The object that joins these unrelated interface is called an Adapter.
// An Adapter pattern acts as a connector between two incompatible interfaces
// that otherwise cannot be connected directly. An Adapter wraps an existing class with a new interface
// so that it becomes compatible with the client’s interface.
interface AppleCharger{
    void chargeApplePhone();
}
class IphoneCharger implements AppleCharger{
    @Override
    public void chargeApplePhone() {
        System.out.println("Your Iphone is charging!!!");
    }
}
class Iphone13{
    AppleCharger appleCharger;
    public Iphone13(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }
    public void chargeIphone13(){
        appleCharger.chargeApplePhone();
    }
}
interface AndroidCharger{
    void chargeAndroidPhone();
}
class PixelCharger implements AndroidCharger{
    @Override
    public void chargeAndroidPhone() {
        System.out.println("Your Pixel phone is charging!!");
    }
}
class Pixel5{
    AndroidCharger androidCharger;
    public Pixel5(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }
    public void chargePixel5(){
        androidCharger.chargeAndroidPhone();
    }
}
class AndroidChargerAdapter implements AppleCharger{
    AndroidCharger androidCharger;
    public AndroidChargerAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }
    @Override
    public void chargeApplePhone() {
        androidCharger.chargeAndroidPhone();
        System.out.println("your Iphone is charging using adapter");
    }
}
public class AdapterDesignPattern {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new PixelCharger();
        // pixel phone charger pin is given as input to adapter
        AppleCharger appleCharger = new AndroidChargerAdapter(androidCharger);
        // The another port of adapter which can charge iphone is given to iphone to charge it
        Iphone13 iphone13 = new Iphone13(appleCharger);
        iphone13.chargeIphone13();
        // Pixel charger pin is given as input to adapter on one side
        // The another side of adapter which has iphone pin is given to iphone to charge it
        // We successfully charged iphone using pixel phone charger via adapter.
    }
}
