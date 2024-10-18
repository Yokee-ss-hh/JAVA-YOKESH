package org.dsa.structuraldp.compositedp;

import java.util.ArrayList;
import java.util.List;

public class ShapeComposite {
    List<Shape> shapes = new ArrayList<>();
    public void addShape(Shape s){
        this.shapes.add(s);
    }
    public void removeShape(Shape s){
        this.shapes.remove(s);
    }
    public void clearShapes(){
        this.shapes.clear();
    }
    public void printShapes(String color){
        for(Shape s: shapes){
            s.draw(color);
        }
    }
}
