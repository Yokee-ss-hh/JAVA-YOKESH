package MyJava;

public class WrapperClassInstanceMethods {
    public static void main(String[] args) {
        Integer i = 2354321;
        Integer j = 2687654;
        System.out.println(i==j); // true
        System.out.println(i.equals(j)); // true
        System.out.println(i.hashCode()); // returns the integer equivalent
        System.out.println(i.getClass()); // class java.lang.Integer
        System.out.println(i.toString()+"->"+(i.toString()).getClass());
        System.out.println(i.byteValue());
        System.out.println(i.shortValue());
        System.out.println(i.longValue());
        System.out.println(i.floatValue());
        System.out.println(i.doubleValue());
        System.out.println(i.intValue());
        System.out.println(i.compareTo(j)); // compares 2 Integers only by calling compare() method internally
        // compare() returns -1 if i<j , 0 if i==j, 1 if i > j
        System.out.println(i instanceof Integer);

        // Similarly for all other data types the above methods are available

    }
}
