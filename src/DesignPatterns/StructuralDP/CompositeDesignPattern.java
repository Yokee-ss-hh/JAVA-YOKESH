package DesignPatterns.StructuralDP;
// composite pattern is a partitioning design pattern. The composite pattern describes a group of objects
// that are treated the same way as a single instance of the same type of object.
// The intent of a composite is to “compose” objects into tree structures to represent part-whole hierarchies.
// Implementing the composite pattern lets clients treat individual objects and compositions uniformly.
// Composite DP is used when we have a requirement where objects has a tree like structure
// There are 4 parts in composite DP
// 1) Component: Component declares the interface for objects in the composition and for accessing and managing its child components
// 2) Composition: Composite stores child components and implements child related operations in the component interface.
// 3) Leaf: Leaf defines behavior for primitive objects in the composition. It represents leaf objects in the composition.
// 4) Client: Client manipulates the objects in the composition through the component interface.
// In binary tree hierarchy all nodes which have child are called compositions
// All leaf nodes are called leaf in composite design pattern
/*
                 c1
                / \
               c2  c3
             /  \ / \
            l1 l2 l3 l4
 */
// In above diagram l1, l2 are leafs and these 2 objects will be stored in c2
// l3, l4 leaf objects will be stored in c3
// Generally If we want only methods to be used for all leafs and compositions we prefer interface
// If we want some type of variables which are common for all leafs and compositions , use abstract classes

import java.util.ArrayList;
import java.util.List;

// ------Component------
abstract class Department{
    public String departmentName;
    public final String companyName = "Yokesh Robotics";
    public Integer departmentId;
    public Department(String departmentName, Integer departmentId) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }
    public abstract void showDepartmentData();
}
// --------Composite 1--------
class TechnologyDepartment extends Department{
    public List<Department> technologyDepartments;
    public TechnologyDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
        this.technologyDepartments = new ArrayList<>();
    }
    public void addNewDepartment(Department department){
        this.technologyDepartments.add(department);
    }
    public void removeExistingDepartment(Department department){
        this.technologyDepartments.remove(department);
    }
    public void showAllDepartments(){
        System.out.println(technologyDepartments);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
// ---------Leaf 1 under composite 1----------
class DevelopmentDepartment extends Department{
    public DevelopmentDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
// --------Leaf 2 under composite 2---------
class QaDepartment extends Department{
    public QaDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
// --------Composite 2---------
class SalesDepartment extends Department{
    public List<Department> salesDepartments;
    public SalesDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
        this.salesDepartments = new ArrayList<>();
    }
    public void addNewDepartment(Department department){
        this.salesDepartments.add(department);
    }
    public void removeExistingDepartment(Department department){
        this.salesDepartments.remove(department);
    }
    public void showAllDepartments(){
        System.out.println(salesDepartments);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
class LocalSalesDepartment extends Department{
    public LocalSalesDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
class GlobalSalesDepartment extends Department{
    public GlobalSalesDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
class HeadDepartment extends Department{
    public List<Department> departments;
    public HeadDepartment(String departmentName, Integer departmentId) {
        super(departmentName, departmentId);
        this.departments = new ArrayList<>();
    }
    public void addNewDepartment(Department department){
        this.departments.add(department);
    }
    public void removeExistingDepartment(Department department){
        this.departments.remove(department);
    }
    public void showAllDepartments(){
        System.out.println(departments);
    }
    @Override
    public void showDepartmentData() {
        System.out.println(String.format("%s -- %s -- %s",companyName, departmentId, departmentName));
    }
}
/*
                                  Department(Component) --> Can be abstract class/ interface
                                        |
                                  Head Department(Composition)
                      ----------------------------------------
                     /                                        \
           Technology Department(Composition)              Sales Department(Composition)
                -----------                                ------------
               /            \                             /             \
          Development(Leaf) QA(Leaf)                    Local(Leaf)    Global(Leaf)
 */
public class CompositeDesignPattern {
    public static void main(String[] args) {
        Department developmentDepartment = new DevelopmentDepartment("development department",1234987);
        Department qaDepartment = new QaDepartment("quality assurance department",8672161);

        Department localSalesDepartment = new LocalSalesDepartment("local sales department",7652312);
        Department globalSalesDepartment = new LocalSalesDepartment("global sales department",7123098);

        TechnologyDepartment technologyDepartment = new TechnologyDepartment("technology department",2345987);
        technologyDepartment.addNewDepartment(developmentDepartment);
        technologyDepartment.addNewDepartment(qaDepartment);

        SalesDepartment salesDepartment = new SalesDepartment("sales department",8120932);
        salesDepartment.addNewDepartment(localSalesDepartment);
        salesDepartment.addNewDepartment(globalSalesDepartment);

        HeadDepartment headDepartment = new HeadDepartment("head department",7612341);
        headDepartment.addNewDepartment(technologyDepartment);
        headDepartment.addNewDepartment(salesDepartment);

        headDepartment.departments.get(0).showDepartmentData();
        headDepartment.departments.get(1).showDepartmentData();

        TechnologyDepartment dep1 = (TechnologyDepartment) headDepartment.departments.get(0);
        dep1.technologyDepartments.get(0).showDepartmentData();
        dep1.technologyDepartments.get(1).showDepartmentData();

        SalesDepartment dep2 = (SalesDepartment) headDepartment.departments.get(1);
        dep2.salesDepartments.get(0).showDepartmentData();
        dep2.salesDepartments.get(1).showDepartmentData();

        // The client can use the top level node (Composite object which is Head Department) to access
        // any nodes (Composites, leafs) under it to get data. That means client is treating all objects(Department) in a tree
        // (Technology object, Development object, Qa object, Sales object, Local sales object, Global sales object)
        // structure like a single object of same(Department) type(Head department object)
        // The main note is to make composites and leafs to implement/ extend component interface/abstract class.
    }
}
