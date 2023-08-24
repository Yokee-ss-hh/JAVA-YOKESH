package DesignPatterns.CreationalDP;

import java.util.HashMap;
import java.util.Map;

abstract class Shape{
    private int x;
    private int y;
    private String color;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shape(){}
    public Shape(Shape target){
        if(target != null){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }
    public abstract Shape clone();
}

class Circle extends Shape{

    private static final String type = "CIRCLE";

    @Override
    public String toString() {
        return "CIRCLE OBJECT";
    }

    private int radius;
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public Circle(){}
    @Override
    public Shape clone() {
        return new Circle(this);
    }
    public Circle(Circle target){
        super(target);
        if(target != null){
            this.radius = target.radius;
        }
    }
}

class Rectangle extends Shape{

    private static final String type = "RECTANGLE";
    @Override
    public String toString() {
        return "RECTANGLE OBJECT";
    }
    public Rectangle(){}
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
    public Rectangle(Rectangle target){
        super(target);
    }
}

class ShapeCache{
    public static Map<Integer, Shape> shapeMap = new HashMap<>();
}
public class PrototypeDesignPattern {
    public static void main(String[] args) {

        Circle c1 = new Circle();
        c1.setX(10);
        c1.setY(20);
        c1.setColor("GREEN");
        c1.setRadius(15);
        ShapeCache.shapeMap.put(1,c1);

        Rectangle r1 = new Rectangle();
        r1.setX(10);
        r1.setY(20);
        r1.setColor("WHITE");
        ShapeCache.shapeMap.put(2,r1);

        Circle clonedC1 = (Circle) ShapeCache.shapeMap.get(1).clone();
        System.out.println(clonedC1.hashCode() == c1.hashCode());

        Rectangle clonedR1 = (Rectangle) ShapeCache.shapeMap.get(2).clone();
        System.out.println(clonedR1.hashCode() == r1.hashCode());
    }
}
