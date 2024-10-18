package org.dsa.structuraldp.facadedp;

public class SteeringImpl implements Steering{
    @Override
    public void turnLeft() {
        System.out.println("turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("turning right");
    }
}
