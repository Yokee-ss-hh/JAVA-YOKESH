package org.dsa.structuraldp.flyweightdp;

public class Main {
    public static void main(String[] args) {
        // Here Thin, Medium & Thick are intrinsic and are shareable between multiple pens
        // colors are extrinsic and given flexibility to client to decide the color
        Pen pen1 = PenFactory.getThinPen("red");
        pen1.draw("Hello");

        Pen pen2 = PenFactory.getThinPen("red");
        pen2.draw("Hi");
    }
}
