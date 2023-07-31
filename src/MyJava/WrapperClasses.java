package MyJava;

public class WrapperClasses {
    public static void main(String[] args) {
        // Wrapper classes provides support to use primitive data types as objects
        // We can store null as well
        // int a = null; -> error
        // Integer a = null; -> valid as 'a' is an object
        byte b = 21;
        short s = 29931;
        int i = 231231254;
        long l = 7847103219L;
        float f = 654.765f;
        double d = 543.23421D;
        char c = 'H';
        boolean bool = true;
        // --------auto boxing: primitive types to wrapper objects-----------
        Byte b1 = b; // we can use Byte.valueOf(b); also
        Short s1 = s;
        Integer i1 = i;
        Long l1 = l;
        Float f1 = f;
        Double d1 = d;
        Character c1 = c;
        Boolean bool1 = bool;
        System.out.println(b1);
        System.out.println(b1 instanceof Byte);
        System.out.println(s1);
        System.out.println(s1 instanceof  Short);
        System.out.println(i1);
        System.out.println(i1 instanceof Integer);
        System.out.println(l1);
        System.out.println(l1 instanceof Long);
        System.out.println(f1);
        System.out.println(f1 instanceof Float);
        System.out.println(d1);
        System.out.println(d1 instanceof Double);
        System.out.println(c1);
        System.out.println(c1 instanceof Character);
        System.out.println(bool1);
        System.out.println(bool1 instanceof Boolean);
        // ----------unboxing: wrapper objects to primitives-------------
        System.out.println("----------------------------------------");
        byte b2 = b1; // can use byte b2 = b1.byteValue()
        System.out.println(b2);
        short s2 = s1;
        System.out.println(s2);
        int i2 = i1;
        System.out.println(i2);
        long l2 = i1;
        System.out.println(l2);
        float f2 = f1;
        System.out.println(f2);
        double d2 = d1;
        System.out.println(d2);
        char c2 = c1;
        System.out.println(c2);
        boolean bool2 = bool1;
        System.out.println(bool2);
        System.out.println("----------------------------------");
    }

}
