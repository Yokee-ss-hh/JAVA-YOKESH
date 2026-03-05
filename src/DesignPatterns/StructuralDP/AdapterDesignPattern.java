package DesignPatterns.StructuralDP;
// Helps in managing 2 incompatible interfaces to work together
// I want to charge my Iphone with USB type charger but Iphone only supports lightening charger
// Client: The main method that calls the code which gives the whole adapter functionality (Which is me)
// Target: This is the interface the client knows how to use (I know only how to use lightening port)
// Adaptee: The useful thing that exists to help the client (The USB Charger)
// Adapter: A new class which helps us to use adaptee to achieve our goal (A UsbToLightening adapter)
// Adapter dp allows the user look for the fix for a problem. Bridge dp allows the user to make a version
// so that the user don't look for a fix later
interface AdapterTarget{
    void charge();
}

class UsbCharger{
    public String  chargeWithUsb(){
        return "charging with usb cable";
    }
}

class UsbToLighteningAdapter implements AdapterTarget{
    private final UsbCharger usbCharger;
    UsbToLighteningAdapter(UsbCharger usbCharger){
        this.usbCharger=usbCharger;
    }
    @Override
    public void charge(){
        System.out.println("Iphone is "+usbCharger.chargeWithUsb());
    }
}
public class AdapterDesignPattern {
    public static void main(String[] args) {
        AdapterTarget iPhoneCharger = new UsbToLighteningAdapter(new UsbCharger());
        iPhoneCharger.charge();
    }
}
