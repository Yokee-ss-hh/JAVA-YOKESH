package DesignPatterns.CreationalDP;
import java.util.*;

// Shallow copy
class Officer implements Cloneable{
    private String name;
    private Map<String,String> children;
    public void setName(String name){
        this.name = name;
    }
    public void setChildren(Map<String,String> map){
        this.children = map;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String getName() {
        return name;
    }
    public Map<String, String> getChildren() {
        return children;
    }
}

// Deep copy
class Worker implements Cloneable{
    private String name;
    private Map<String,String> children;
    public void setName(String name){
        this.name = name;
    }
    public void setChildren(Map<String,String> map){
        this.children = map;
    }
    public String getName() {
        return name;
    }
    public Map<String, String> getChildren() {
        return children;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        Worker worker = (Worker) object;
        worker.setName(new String(this.name));
        Iterator<String> it = this.children.keySet().iterator();
        // Deep Copy of field by field
        String key;
        Map<String, String> hm = new HashMap<>();
        while (it.hasNext()) {
            key = it.next();
            hm.put(key, this.children.get(key));
        }
        worker.setChildren(hm);
        return worker;
    }
}

public class Employee{
    public static void main(String[] args) throws CloneNotSupportedException{
        Officer officer = new Officer();
        officer.setName("yokesh");
        Map<String,String> map = new HashMap<>();
        map.put("x","x");
        map.put("y","y");
        officer.setChildren(map);

        Officer shallowClonedOfficer = (Officer) officer.clone();

        System.out.println(officer == shallowClonedOfficer);
        System.out.println(officer.getChildren() == shallowClonedOfficer.getChildren());
        System.out.println(officer.getName() == shallowClonedOfficer.getName());

        // Even though objects are different, their data is still pointing to same address.
        // We need to do deep copying.

        Worker worker = new Worker();
        worker.setName("yokesh");
        Map<String,String> map1 = new HashMap<>();
        map1.put("x","x");
        map1.put("y","y");
        worker.setChildren(map1);

        Worker deepClonedWorker = (Worker) worker.clone();
        System.out.println(worker == deepClonedWorker);
        System.out.println(worker.getChildren() == deepClonedWorker.getChildren());
        System.out.println(worker.getName() == deepClonedWorker.getName());
    }
}
