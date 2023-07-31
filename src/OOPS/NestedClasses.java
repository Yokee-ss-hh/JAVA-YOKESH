package OOPS;
// Nested classes are of 2 types
// Static Nested classes and Non-static nested classes
// Static Nested classes are simply called as static nested classes
// Non-static nested classes are called inner classes
// Static class -> Can only access static variables and static methods from outer class
// Non-static class/ Inner class -> Can access all types of data from outer class including private
// members also
// Inner classes again classified into 3 types
// i) Inner class inside a method, ii) Inner class in the outer class scope
// iii) Anonymous inner class and iV) static inner class

// --------------------------Static and Non-static/Inner class demo--------------------------

// static nested class example and non-static nested class
class OuterClass{
    static int a = 23;
    final int b = 32;

    int c = 543;

    static final int a1 = 364718;

    static void m1(){
        System.out.println("static method1 in outer class");
    }
    void m2(){ // cannot be called by static inner class
        System.out.println("instance method2 in outer class");
    }

    static class Inner1{
        static int d = 543;
        int e = 98765;

        static void m3(){
            System.out.println("static method3 in inner1 class");
        }
        void m4(){
            System.out.println("instance method4 in inner1 class");
        }

        void callOuterClassStaticMethod(){
            m1();
        }

    }
    class Inner2{

        // static variables and static methods are restricted only to top level classes
        // Hence, cannot create in inner classes.
        // There is no restriction to create static variables and methods inside inner static classes as discussed
        // in Inner1 class
        // static int f = 21312; -> Cannot declare static variables inside inner class, use JDK 16+
        final static int g = 7842719;

        int h = 12121;

        final int i = 99999;

        void m5(){
            System.out.println("instance method5 of inner2 class");
        }
        // Cannot create static method inside inner class -> Upgrade to JDK 16+
        void callOuterClassMethods(){
            m1();
            m2();
        }
    }
}

// The below class demonstrates 3 types of inner classes
// 1. Inner Class in outer class space
// 2. Inner class inside a method
// 3. Anonymous class (Covered in another file)
// 4. Static inner class -> Contains only static data and static methods
class OuterClass2{
    int oc2 = 23;
    class InnerTypeOne{ // Type 1 Inner Class
        int oc3 = 4321;
        void getOuterClass2Data(){
            System.out.println(oc2);
            System.out.println(oc3);
        }
    }
    void outerMethodForInnerTypeTwo(){ // Type 2 Inner Class
        class InnerTypeTwo{
            InnerTypeTwo(){
                System.out.println("I am default constructor of InnerTypeTwo class");
            }
            void innerTypeTwoMethod(){
                System.out.println("I am inside a inner class which is inside a method");
            }
        }

        InnerTypeTwo type2 = new InnerTypeTwo();
        type2.innerTypeTwoMethod();
    }

    // Type 3 Inner Class -> Anonymous inner class
    // Anonymous Inner Classes is discussed in separate file "AnonymousInnerClasses" please refer to that file

}

// type 4: static inner classes can be invoked directly without creating object
class StaticOuter{
    static class StaticInner{ // static inner class type 1
        static void innerMm1(){
            System.out.println("innerMm1 method");
        }
    }
}

class NestedClasses{
    public static void main(String[] args) {
        OuterClass.Inner1 i1 = new OuterClass.Inner1();
        System.out.println(i1.d);
        System.out.println(i1.e);
        i1.m3();
        i1.m4();
        i1.callOuterClassStaticMethod();

        OuterClass o = new OuterClass();
        OuterClass.Inner2 i2 = o. new Inner2();
        System.out.println(i2.g);
        System.out.println(i2.h);
        System.out.println(i2.i);
        i2.m5();
        i2.callOuterClassMethods();

        System.out.println("--------3 types of inner classes----------");
        OuterClass2 c2 = new OuterClass2();
        OuterClass2.InnerTypeOne ito1 = c2. new InnerTypeOne();

        System.out.println(ito1.oc3);
        ito1.getOuterClass2Data();
        c2.outerMethodForInnerTypeTwo();

        // 4 th type of inner class
        StaticOuter.StaticInner.innerMm1();
    }
}


