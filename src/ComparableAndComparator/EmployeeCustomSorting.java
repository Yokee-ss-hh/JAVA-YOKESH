package ComparableAndComparator;
import java.util.Comparator;

public class EmployeeCustomSorting {
        Comparator<Employee> comparatorByName = (x,y)->{
          return x.employeeName.compareTo(y.employeeName);
        };
        Comparator<Employee> comparatorByAge = (x,y) ->{
          return Integer.valueOf(x.employeeAge).compareTo(Integer.valueOf(y.employeeAge));
        };
        Comparator<Employee> comparatorByDesignation = (x,y) ->{
          return x.employeeDesignation.compareTo(y.employeeDesignation);
        };
}
