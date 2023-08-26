package DesignPatterns.BehavioralDP;
// The State design pattern belongs to the behavioral family of pattern that deals
// with the runtime object behavior based on the current state
// Use state pattern when in any application, when we are dealing with an object which can be in
// different states during it’s life-cycle
interface TvState{
    void doAction();
}
class TvOnState implements TvState{
    @Override
    public void doAction() {
        System.out.println("Tv is turned on");
        System.out.println("Performing BIOS operations and executing micro controllers commands...");
        System.out.println("Preparing for display functions.......");
    }
}
class TvOffState implements TvState{
    @Override
    public void doAction() {
        System.out.println("Tv is turned off");
        System.out.println("Clearing virtual cache.....");
        System.out.println("Unloading internal disk memory....");
    }
}
class TvContext implements TvState{
    private TvState tvState;
    public void setTvState(TvState tvState){
        this.tvState = tvState;
    }
    public TvState getTvState(){
        return tvState;
    }
    @Override
    public void doAction() {
        tvState.doAction();
    }
}
public class StateDesignPattern {
    public static void main(String[] args) {
        TvContext context = new TvContext();
        TvState state1 = new TvOnState();
        TvState state2 = new TvOffState();

        context.setTvState(state1);
        System.out.println(context.getTvState());
        context.doAction();

        context.setTvState(state2);
        System.out.println(context.getTvState());
        context.doAction();
    }
}
