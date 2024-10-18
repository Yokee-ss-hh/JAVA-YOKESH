package org.dsa.structuraldp.bridgedp;

public class HdProcessor implements VideoProcessor{
    @Override
    public void process(String videoFile) {
        System.out.println(videoFile+" in HD");
    }
}
