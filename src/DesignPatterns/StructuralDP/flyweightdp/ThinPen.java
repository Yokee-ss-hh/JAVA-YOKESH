package org.dsa.structuraldp.flyweightdp;

public class ThinPen implements Pen{
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public void draw(String content) {
        System.out.println(content+" written using "+color+" pen");
    }
}
