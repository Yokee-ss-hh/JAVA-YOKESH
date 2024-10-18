package org.dsa.structuraldp.compositedp;

public class Circle implements Shape{
    @Override
    public void draw(String color) {
        System.out.println("Circle of color "+color);
    }
}
