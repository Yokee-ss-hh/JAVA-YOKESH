package OOPS;
// Variable shadowing:
// Variable Shadowing happens when a variable in an inner scope is declared with the same name as a
// variable in the outer scope.
// In this case, the variable in the inner scope shadows (masks) the variable in the outer scope.
// Variable shadowing happens even when both the variables with the same name have different data types.
// Variable Shadowing are 2 types -> Local variable shadowing and Method argument shadowing

// Variable hiding:
// Variable Hiding happens when a variable declared in the child class has the same name as the variable
// declared in the parent class.
// In contrast, variable shadowing happens when a variable in the inner scope has the same name as
// the variable in the outer scope. The child class' variables tend to hide the
// parent class' variables when they have the same name.
// Variable hiding happens even when both the variables with the same name have different data types.

class StudentShadow{
    String studentName = "yokesh";
    int id = 1;

    void localVariableShadowing(){
        String studentName = "yoki";
        System.out.println(studentName);
    }

    void methodArgumentShadowing(String studentName){
        System.out.println(studentName);
    }

    // How to call instance variable when shadowing occurs -> use this keyword
    void overcomeShadowing(){
        String studentName = "hema";
        System.out.println(studentName);
        System.out.println(this.studentName);
    }
}

class University{
    String s = "mars";

    String id = "one";
    void printS(){
        System.out.println(s);
    }
    void printId(){
        System.out.println(id);
    }
}

class Student extends University{
    String s = "saturn";

    int id = 1;
    @Override
    void printS(){
        System.out.println(s);
    }
    @Override
    void printId(){
        System.out.println(id);
    }
}

public class VariableShadowingAndHiding {
    public static void main(String[] args) {
        // variable shadowing
        StudentShadow ss = new StudentShadow();
        ss.localVariableShadowing();
        ss.methodArgumentShadowing("visa");
        ss.overcomeShadowing();

        // variable hiding
        Student student = new Student();
        University university = new University();
        System.out.println(university.s); // call goes to University class
        System.out.println(university.id); // call goes to University class
        // Even though subclass has a variable 's' which is of same type and same name of parent class and
        // A variable "id" with same name and different type. The subclass hides its parent class variables
        // "s" and "id".
        System.out.println(student.s); // prints "saturn" because subclass hided parent class variable "s"
        // which has data as "mars".
        System.out.println(student.id); // prints 1 because subclass hided parent class variable "id" which
        // has data as "1".


        // Now the issue comes as when we use Parent class reference using Child class object.
        University u1 = new Student();
        // Calling method printS() will go to subclass Parent
        u1.printS(); // prints "saturn" due to method overriding
        System.out.println(u1.id); //  prints "one" and call goes to the type of "u1" i.e, University class
        // due to there is no overriding for variables
        // Calling variable 's' will go to parent class University but not to subclass Student
        // Methods only go into polymorphism not data variables
        // Only methods can be overridden in subclass but not parent class variables.
        // At this time, The instance to be called will depend on the type of referencing variable but not
        // the type of object.
    }

}
