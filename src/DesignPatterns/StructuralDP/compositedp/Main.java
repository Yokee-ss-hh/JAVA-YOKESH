package org.dsa.structuraldp.compositedp;

public class Main {
    public static void main(String[] args) {
        // When we need to create a structure in a way that the objects in the structure has to be treated the same way
        // we can apply composite design pattern
        ShapeComposite shapeComposite = new ShapeComposite();
        shapeComposite.addShape(new Circle());
        shapeComposite.addShape(new Circle());
        shapeComposite.addShape(new Rectangle());
        shapeComposite.printShapes("Red");
    }
}
