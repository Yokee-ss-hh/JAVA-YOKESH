package DesignPatterns.StructuralDP;
// Decorator design pattern allows us to dynamically add functionality and behavior to an object without
// affecting the behavior of other objects within a same class/ other objects of classes implementing
// same interface.
// Decorator design pattern provides a wrapper class to the existing class

interface Shape{
    String draw();
}
class Circle implements Shape{
    public final String type = "CIRCLE";
    @Override
    public String draw() {
        return "Drawing Circle";
    }
}
class Rectangle implements Shape{
    public final String type = "RECTANGLE";
    @Override
    public String draw() {
        return "Drawing Rectangle";
    }
}
abstract class ShapeDecorator implements Shape{
    protected Shape shapeDecorator;
    ShapeDecorator(Shape shapeDecorator){
        this.shapeDecorator = shapeDecorator;
    }
    @Override
    public String draw() {
        return shapeDecorator.draw();
    }
}
class RedShapeDecorator extends ShapeDecorator{
    RedShapeDecorator(Shape shapeDecorator) {
        super(shapeDecorator);
    }
    @Override
    public String draw() {
        return shapeDecorator.draw()+" And "+addRedBorder();
    }
    private String addRedBorder(){
        return "Adding red border";
    }
}
class GoldCoatingDecorator extends ShapeDecorator{
    GoldCoatingDecorator(Shape shapeDecorator) {
        super(shapeDecorator);
    }
    @Override
    public String draw() {
        return shapeDecorator.draw()+" And "+addRedBorder();
    }
    private String addRedBorder(){
        return "Adding gold coating!!";
    }
}
public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new GoldCoatingDecorator(new RedShapeDecorator(circle));
        System.out.println(redCircle.draw());

        Shape rectangle = new Rectangle();
        Shape redRectangle = new GoldCoatingDecorator(new RedShapeDecorator(rectangle));
        System.out.println(redRectangle.draw());
    }
}
