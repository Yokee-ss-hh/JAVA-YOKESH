package DesignPatterns.CreationalDP;
// Provide an interface for creating families of related or dependent objects without
// specifying their concrete classes.
// Inorder to create families of related objects we will be using an abstract factory which will
// be implemented to create multiple factories,each factory related to each type of family object
// which are in turn related/ dependent to each other.
// Multiple factories are created by implementing common interface factory
// This is factory of factories in abstract factory design pattern when compared to just 1 factory in factory design pattern
// This design pattern adds one more abstraction layer to factory design pattern

// There are 4 parts in creating abstract design pattern
// 1) Abstract products
// 2) Concrete products
// 3) Abstract factory
// 4) Concrete factories

// ----------------------------------------Example 1------------------------------------

// Abstract product 1
interface ElectricVehicle{
    void buildElectricVehicle();
}

// Abstract product 2
interface FuelVehicle{
    void buildFuelVehicle();
}

// concrete product 1 of tata type by implementing abstract product 1
class TataElectricVehicle implements ElectricVehicle{
    @Override
    public void buildElectricVehicle() {
        System.out.println("building tata electric vehicle");
    }
}

// concrete product 2 of tata type by implementing abstract product 2
class TataFuelVehicle implements FuelVehicle{
    @Override
    public void buildFuelVehicle() {
        System.out.println("building tata fuel vehicle");
    }
}

// concrete product 1 of mahindra type by implementing abstract product 1
class MahindraElectricVehicle implements ElectricVehicle{
    @Override
    public void buildElectricVehicle() {
        System.out.println("building mahindra electric vehicle");
    }
}

// concrete product 2 of mahindra type by implementing abstract product 2
class MahindraFuelVehicle implements FuelVehicle{
    @Override
    public void buildFuelVehicle() {
        System.out.println("building mahindra fuel vehicle");
    }
}

// abstract factory
interface AbstractVehicleFactory{
    ElectricVehicle createElectricVehicle();
    FuelVehicle createFuelVehicle();
}

// concrete factory 1 of type tata implementing abstract factory
class TataVehicleFactory implements AbstractVehicleFactory{
    @Override
    public ElectricVehicle createElectricVehicle() {
        return new TataElectricVehicle();
    }
    @Override
    public FuelVehicle createFuelVehicle() {
        return new TataFuelVehicle();
    }
}

// concrete factory 2 of type mahindra implementing abstract factory
class MahindraVehicleFactory implements AbstractVehicleFactory{
    @Override
    public ElectricVehicle createElectricVehicle() {
        return new MahindraElectricVehicle();
    }
    @Override
    public FuelVehicle createFuelVehicle() {
        return new MahindraFuelVehicle();
    }
}

// ----------------------------------------Example 2------------------------------------
// Abstract Product - Button
interface Button{
    void render();
}
// Abstract Product - CheckBox
interface CheckBox{
    void render();
}
// Concrete Product - WindowsButton
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button");
    }
}
// Concrete Product - MacButton
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac button");
    }
}
// Concrete Product - WindowsCheckbox
class WindowsCheckbox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox");
    }
}
// Concrete Product - MacCheckbox
class MacCheckbox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac checkbox");
    }
}
// Abstract Factory
interface GUIFactory {
    Button createButton();
    CheckBox createCheckbox();
}
// Concrete Factory - WindowsFactory
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    @Override
    public CheckBox createCheckbox() {
        return new WindowsCheckbox();
    }
}
// Concrete Factory - MacFactory
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacCheckbox();
    }
}
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        AbstractVehicleFactory abstractVehicleFactory1 = new TataVehicleFactory();
        abstractVehicleFactory1.createFuelVehicle().buildFuelVehicle();
        abstractVehicleFactory1.createElectricVehicle().buildElectricVehicle();

        AbstractVehicleFactory abstractVehicleFactory2 = new MahindraVehicleFactory();
        abstractVehicleFactory2.createFuelVehicle().buildFuelVehicle();
        abstractVehicleFactory2.createElectricVehicle().buildElectricVehicle();

        GUIFactory guiFactory1 = new WindowsFactory();
        guiFactory1.createButton().render();
        guiFactory1.createCheckbox().render();

        GUIFactory guiFactory2 = new MacFactory();
        guiFactory2.createButton().render();
        guiFactory2.createCheckbox().render();
    }
}
