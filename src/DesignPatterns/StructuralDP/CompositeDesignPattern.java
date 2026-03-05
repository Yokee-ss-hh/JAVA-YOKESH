package DesignPatterns.StructuralDP;

import java.util.ArrayList;
import java.util.List;

// Composes objects into tree structures to represent part-whole hierarchies
// Leaf: A class implementing component, The individual object, the lowest level in the structure
// Component: A interface defining the structure which is generic
// Composite: A collection object to hold leafs of type Component
// Client: The user performing the actions
interface RootStructure{
    void showDetails();
    long getSize();
}

class File implements RootStructure{
    String name;
    long size;
    File(String name, long size){
        this.name=name;
        this.size=size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: "+this.name);
    }

    @Override
    public long getSize() {
        return this.size;
    }
}

class Folder implements RootStructure{
    private String name;
    private List<RootStructure> fileSystem = new ArrayList<>();
    Folder(String name){
        this.name=name;
    }
    public void add(RootStructure rootStructure){
        this.fileSystem.add(rootStructure);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: "+this.name);
        for(RootStructure rootStructure: fileSystem){
            rootStructure.showDetails();
        }
    }

    @Override
    public long getSize() {
        long total = 0;
        for (RootStructure item : fileSystem) {
            total += item.getSize();
        }
        return total;
    }
}
public class CompositeDesignPattern {
    public static void main(String[] args) {
        File file = new File("abc.txt",300);
        File file1 = new File("xyz.txt",200);
        Folder folder = new Folder("my files");
        folder.add(file);
        folder.add(file1);
        folder.showDetails();
        System.out.println(folder.getSize());
    }
}
