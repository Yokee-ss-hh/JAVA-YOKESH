package MyJava;

public class WrapperClassesCaching{
    public static void main(String[] args) {
        System.out.println("Methods of byte wrapper object");
        // JVM caches byte,short, integer and long objects of range -128 to 127
        // But creating all above 4 using new operator will not get cached
        Byte b1 = 21;
        Byte b2 = 21;
        System.out.println(b1 == b2);// true because they are cached
        Byte b3 = new Byte((byte)20);
        Byte b4 = new Byte((byte)20);
        System.out.println(b3 == b4);// false
        Short s1 = 129;
        Short s2 = 129;
        System.out.println(s1 == s2); // false as they aren't cached
        Short s3 = 127;
        Short s4 = 127;
        System.out.println(s3 == s4); // true due to caching
    }
}
