package org.dsa.structuraldp.bridgedp;

public class UltraHDProcessor implements VideoProcessor{
    @Override
    public void process(String videoFile) {
        System.out.println(videoFile+" in Ultra HD");
    }
}
