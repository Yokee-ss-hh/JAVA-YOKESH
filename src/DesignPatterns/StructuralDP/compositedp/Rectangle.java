package org.dsa.structuraldp.compositedp;

public class Rectangle implements Shape{
    @Override
    public void draw(String color) {
        System.out.println("Rectangle of color "+color);
    }
}
