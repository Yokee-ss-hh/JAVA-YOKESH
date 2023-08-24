package DesignPatterns.BehavioralDP;
interface ICommand{
    void execute();
}
interface ILight{
    void turnOnLight();
    void turnOffLight();
}
interface IFan{
    void turnOnFan();
    void turnOffFan();
}
class Light implements ILight{
    @Override
    public void turnOnLight() {
        System.out.println("Turning on light");
    }
    @Override
    public void turnOffLight() {
        System.out.println("Turning off light");
    }
}
class Fan implements IFan{
    @Override
    public void turnOnFan() {
        System.out.println("Turning on fan");
    }
    @Override
    public void turnOffFan() {
        System.out.println("Turning off fan");
    }
}
class TurnOnLightCommand implements ICommand{
    ILight iLight;
    TurnOnLightCommand(ILight iLight){
        this.iLight = iLight;
    }
    @Override
    public void execute() {
        iLight.turnOnLight();
    }
}
class TurnOffLightCommand implements ICommand{
    ILight iLight;
    TurnOffLightCommand(ILight iLight){
        this.iLight = iLight;
    }
    @Override
    public void execute() {
        iLight.turnOffLight();
    }
}
class TurnOnFanCommand implements ICommand{
    IFan iFan;
    TurnOnFanCommand(IFan iFan){
        this.iFan = iFan;
    }
    @Override
    public void execute() {
        iFan.turnOnFan();
    }
}
class TurnOffFanCommand implements ICommand{
    IFan iFan;
    TurnOffFanCommand(IFan iFan){
        this.iFan = iFan;
    }
    @Override
    public void execute() {
        iFan.turnOffFan();
    }
}
class HomeRemote{
    ICommand iCommand;
    void setICommand(ICommand iCommand){
        this.iCommand = iCommand;
    }
    void pressButton(){
        iCommand.execute();
    }
}
public class CommandDesignPattern {
    public static void main(String[] args) {
        ILight livingRoomLight = new Light();
        ILight bedRoomLight = new Light();
        IFan livingRoomFan = new Fan();
        IFan bedRoomFan = new Fan();

        HomeRemote homeRemote = new HomeRemote();
        homeRemote.setICommand(new TurnOnLightCommand(livingRoomLight));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOnFanCommand(livingRoomFan));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOffLightCommand(livingRoomLight));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOffFanCommand(livingRoomFan));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOnLightCommand(bedRoomLight));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOnFanCommand(bedRoomFan));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOffLightCommand(bedRoomLight));
        homeRemote.pressButton();

        homeRemote.setICommand(new TurnOffFanCommand(bedRoomFan));
        homeRemote.pressButton();
    }
}
