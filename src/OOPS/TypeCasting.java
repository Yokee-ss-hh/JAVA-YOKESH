package OOPS;

class Teachers{
    String teacherName;
    String teacherSchoolName;

    Teachers(String x, String y){
        this.teacherName = x;
        this.teacherSchoolName = y;
    }

    void printSchoolName(){
        System.out.println(this.teacherSchoolName);
    }
}

class Students extends Teachers{

    String studentName;

    String studentSchoolName;

    Students(String a, String b,String x, String y){
        super(a,b);
        this.studentName = x;
        this.studentSchoolName = y;
    }
    @Override
    void printSchoolName() {
        System.out.println(this.studentSchoolName);
    }
}

public class TypeCasting {
    public static void main(String[] args) {
        // 1.
        Teachers teachers = new Teachers("yokesh","teachers kcrs");
        System.out.println(teachers.teacherName);
        System.out.println(teachers.teacherSchoolName);
        teachers.printSchoolName();
        System.out.println("-------------------------------------------------");
        // 2.
        Students students = new Students("yokesh","teachers kcrs","ravi","students krcs");
        System.out.println(students.teacherName);
        System.out.println(students.teacherSchoolName);
        System.out.println(students.studentName);
        System.out.println(students.studentSchoolName);
        students.printSchoolName();
        System.out.println("--------------------------------------------------");
        // 3. Up casting
        // Upcasting refers to typecasting a child object to a parent object.
        // Implicit, as well as explicit upcasting, is allowed.
        // Methods and variables of the Parent class can be accessed.
        // Parent p = new Child();
        Teachers teacher1 = new Students("yokesh","teachers kcrs","ravi","students krcs");
        System.out.println(teacher1.teacherName);
        System.out.println(teacher1.teacherSchoolName);
        teacher1.printSchoolName();
        System.out.println("---------------------------------------------------");
        // 4. Down casting process
        // Down casting provides casting a parent object to a child object.
        // Implicit down casting is not allowed in Java.
        // Methods and variables of both the Parent and Child classes can be accessed through down casting.
        // Parent p1 = new Child();
        // Child c1 = (Child)p1;
        Teachers t = new Students("yokesh","teachers kcrs","ravi","students krcs");
        Students s = (Students) t;
        System.out.println(s.teacherName);
        System.out.println(s.teacherSchoolName);
        System.out.println(s.studentName);
        System.out.println(s.studentSchoolName);
        s.printSchoolName();
    }
}
