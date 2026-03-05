package DesignPatterns.StructuralDP;

import java.util.HashMap;
import java.util.Map;

// Minimizes memory usage by sharing common data among similar objects
// Ideal for large numbers of fine-grained objects (e.g., characters in a text editor).

interface TreePosition{
    void render(float x, float y);
}
class TreeType implements TreePosition{
    String tree;
    String color;
    TreeType(String tree,String color){
        this.tree=tree;
        this.color=color;
    }
    @Override
    public void render(float x, float y) {
        System.out.println("Rendering "+this.color+" "+this.tree+" at position "+x+" and "+y);
    }
}
class TreeFactory{
    private static final Map<String,TreeType> cache = new HashMap<>();
    public static TreeType getTreeFromCache(String name, String color){
        String key=name+color;
        if(cache.containsKey(key)){
            System.out.println("Getting "+color+" colored "+name+" tree from cache");
            return cache.get(key);
        }
        TreeType newObject = new TreeType(name,color);
        cache.put(key,newObject);
        return newObject;
    }
}
public class FlyweightDesignPattern {
    public static void main(String[] args) {
        TreeType oakTree = TreeFactory.getTreeFromCache("oak","red");
        oakTree.render(12.3312f,3213.31231f);
        TreeType oakTree1 = TreeFactory.getTreeFromCache("oak","red");
        oakTree1.render(7564.32131f,230.4231491f);
        TreeType pineTree = TreeFactory.getTreeFromCache("pine","yellow");
        pineTree.render(89.782774f,78273.231231f);
    }
}
