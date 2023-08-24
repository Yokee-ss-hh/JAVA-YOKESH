package DesignPatterns.StructuralDP;

import java.util.HashMap;

// Flyweight design pattern is used when we need a large number of similar objects that are unique
// in terms of only a few parameters and most of the features are common.
// Implementing this design pattern improves memory performance by creating object once and sharing
// the same object when it is requested in future instead of creating again.
// The objects should have variables of intrinsic and extrinsic states
// intrinsic state means the value of variables remains same whenever a new object is created
// extrinsic state means the value of variables changes according to the clients requirement
// Inorder to require intrinsic state, We need to make objects Immutable

// Java string pool is the example of flyweight design pattern
interface Brush{
    void setColor(Color color);
    void draw();
}
enum Color{
    WHITE, BLACK
}
enum Size{
    SMALL, MEDIUM, LARGE
}
class SmallBrush implements Brush{
    private static final Size size = Size.SMALL; // Intrinsic -> Size is fixed for all small brushes
    public Color color; // Extrinsic
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println(String.format("Painting with %s %s brush",size.toString(),color));
    }
}
class MediumBrush implements Brush{
    private static final Size size = Size.MEDIUM; // Intrinsic -> Size is fixed for all medium brushes
    public Color color; // Extrinsic
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println(String.format("Painting with %s %s brush",size.toString(),color));
    }
}
class LargeBrush implements Brush{
    private static final Size size = Size.LARGE; // Intrinsic -> Size is fixed for all large brushes
    public Color color; // Extrinsic
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println(String.format("Painting with %s %s brush",size.toString(),color));
    }
}
class BrushFactory{
    private static final HashMap<String,Brush> brushFactory = new HashMap<>();
    public static Brush makeSmallBrush(Color color){
        String key = color+Size.SMALL.toString();
        Brush brush = brushFactory.get(key);
        if(brush != null){
            System.out.println("Fetching ball from cache");
            return brush;
        }
        else{
            brush = new SmallBrush();
            brush.setColor(color);
            brushFactory.put(key, brush);
            return brush;
        }
    }
    public static Brush makeMediumBrush(Color color){
        String key = color+Size.MEDIUM.toString();
        Brush brush = brushFactory.get(key);
        if(brush != null){
            System.out.println("Fetching ball from cache");
            return brush;
        }
        else{
            brush = new MediumBrush();
            brush.setColor(color);
            brushFactory.put(key, brush);
            return brush;
        }
    }
    public static Brush makeLargeBrush(Color color){
        String key = color+Size.LARGE.toString();
        Brush brush = brushFactory.get(key);
        if(brush != null){
            System.out.println("Fetching ball from cache");
            return brush;
        }
        else{
            brush = new LargeBrush();
            brush.setColor(color);
            brushFactory.put(key, brush);
            return brush;
        }
    }
}
public class FlyWeightDesignPattern {
    public static void main(String[] args){
        Brush whiteSmallBrush = BrushFactory.makeSmallBrush(Color.WHITE); // New object + Cached
        whiteSmallBrush.draw();
        Brush whiteMediumBrush = BrushFactory.makeMediumBrush(Color.WHITE); // New object + Cached
        whiteMediumBrush.draw();
        Brush whiteLargeBrush = BrushFactory.makeLargeBrush(Color.WHITE); // New object + Cached
        whiteLargeBrush.draw();

        Brush blackSmallBrush = BrushFactory.makeSmallBrush(Color.BLACK); // New object + Cached
        blackSmallBrush.draw();
        Brush blackMediumBrush = BrushFactory.makeMediumBrush(Color.BLACK); // New object + Cached
        blackMediumBrush.draw();
        Brush blackLargeBrush = BrushFactory.makeLargeBrush(Color.BLACK); // New object + Cached
        blackLargeBrush.draw();

        Brush whiteSmallBrushRequestedSecondTime = BrushFactory.makeSmallBrush(Color.WHITE); // fetches from cache
        whiteSmallBrushRequestedSecondTime.draw();

        System.out.println(whiteSmallBrush.hashCode() == whiteSmallBrushRequestedSecondTime.hashCode());
        // true because the object that is accessed second time is fetched from cache
    }
}
