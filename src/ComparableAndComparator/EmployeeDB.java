package ComparableAndComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDB{
    List<Employee> employees;

    EmployeeDB(List<Employee> employees){
        this.employees = employees;
    }


    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Yokesh",23,"developer"));
        employeeList.add(new Employee("kusuma",24,"doctor"));
        employeeList.add(new Employee("Bnn",55,"teacher"));
        employeeList.add(new Employee("Meenaka",54,"teacher"));
        employeeList.add(new Employee("Indrani",70,"grand mother"));

        EmployeeDB employeeDB = new EmployeeDB(employeeList);

        // Sorting using Comparable

        System.out.println(employeeDB.employees);
        Collections.sort(employeeDB.employees);
        System.out.println(employeeDB.employees);

        // Sorting using Comparator
        EmployeeCustomSorting employeeCustomSorting = new EmployeeCustomSorting();

        System.out.println(employeeDB.employees);
        Collections.sort(employeeDB.employees, employeeCustomSorting.comparatorByName);
        System.out.println(employeeDB.employees);
        Collections.sort(employeeDB.employees, employeeCustomSorting.comparatorByDesignation);
        System.out.println(employeeDB.employees);
        Collections.sort(employeeDB.employees, employeeCustomSorting.comparatorByAge);
        System.out.println(employeeDB.employees);
    }
}
