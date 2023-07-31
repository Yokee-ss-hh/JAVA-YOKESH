package MyJava;

public class WrapperClassMethods {

    public static void main(String[] args) {
        Integer a1 = 2343;
        Integer a2 = 4321;
        // General methods
        System.out.println(Integer.compare(a1,a2)); // takes 2 arguments of Integer/int type and returns -1,0,1 depending on their values
        System.out.println(Integer.max(a1,a2)); // takes 2 arguments of Integer/int type
        System.out.println(Integer.min(a1,a2));
        System.out.println(Integer.sum(a1,a2));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES);
        System.out.println(Integer.compare(-100,231)); // This is signed comparison
        System.out.println(Integer.compareUnsigned(-100,231)); // This method isn't useful
        // Java treats negative values passed as parameters to +ve values and compares them.So,
        // Don't use this method regularly
        System.out.println(Integer.bitCount(2));
        System.out.println(Integer.hashCode(23));
        System.out.println(Integer.lowestOneBit(20));
        // 0001 0100 -> Keep right most '1' and make all remaining 1's to '0'
        // 0001 0100 -> 0000 0100 = 4
        System.out.println(Integer.highestOneBit(20));
        // 0001 0100 -> Keep left most '1' and make all remaining 1's to '0'
        // 0001 0100 -> 0001 0000 -> 16
        System.out.println(Integer.numberOfLeadingZeros(10));
        // 0000 0000 0000 1010 -> Number of 0's preceding the left most '1'
        // 28
        System.out.println(Integer.numberOfTrailingZeros(10));
        // 0000 0000 0000 1010 -> Number of 0's succeeding the right most '1'
        // 1
        System.out.println(Integer.reverseBytes(10));
        // 0000 0000 0000 0000 0000 0000 0000 1010
        // 0000 1010 0000 0000 0000 0000 0000 0000
        // 167772160
        System.out.println(Integer.reverse(10));
        // 0000 0000 0000 0000 0000 0000 0000 1010
        // 0101 0000 0000 0000 0000 0000 0000 0000
        // 1342177280
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.toOctalString(10));

        // Parsing integer strings to integers
        // parseInt() takes only strings as parameters
        // parseInt() internally uses valueOf() method
        // parseInt() returns primitive int
        System.out.println(Integer.parseInt("111")); // takes radix as 10 by default
        System.out.println(Integer.parseInt("10",10));
        System.out.println(Integer.parseInt("10",8));
        System.out.println(Integer.parseInt("D",16));
        System.out.println(Integer.parseInt("10101",2));
        System.out.println(Integer.parseInt("10101110",2,5,2));
        System.out.println(Integer.parseInt("123456",1,3,10));

        // valueOf method to convert strings to integers
        // valueOf() takes strings and primitive int as input
        // valueOf() returns Integer object
        System.out.println(Integer.valueOf(23));
        System.out.println(Integer.valueOf("F",16));
        System.out.println(Integer.valueOf("1010",2));
        System.out.println(Integer.valueOf("2000")); // takes 10 as radix by default
        System.out.println(Integer.valueOf('g')); // takes unicode as input and
        // returns it's decimal equivalent

        // int to string conversions
        System.out.println(Integer.toString(23));
        System.out.println(Integer.toString(10,2));
        System.out.println(Integer.toString(13,16));
        System.out.println(Integer.toString(12,8));

        // rotations
        System.out.println(Integer.rotateLeft(12,2));
        // 0000 1100
        // 0011 0000
        // 48
        System.out.println(Integer.rotateRight(12,2));
        // 0000 1100
        // 0000 0011
        // 3

        // --------------------------------------------------------------------
        System.out.println("---------------Float Class---------------");
        // -----------------------------Float Class---------------------------------------
        System.out.println(Float.max(12.32f,32.231f));
        System.out.println(Float.min(32.321f,98.7654f));
        System.out.println(Float.sum(43.21f,98.999f));
        System.out.println(Float.compare(32.23f,98.76f));
        System.out.println(Float.hashCode(32.1234f));
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.BYTES);
        System.out.println(Float.SIZE);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Float.MAX_EXPONENT);
        System.out.println(Float.MIN_EXPONENT);

        Float f1 = Float.NEGATIVE_INFINITY;
        Float f2 = Float.POSITIVE_INFINITY;
        Float f3 = Float.NaN;
        System.out.println(Float.isInfinite(f1));
        System.out.println(Float.isInfinite(f2));
        System.out.println(Float.isNaN(f3));
        System.out.println(Float.isFinite(32.3214f));

        System.out.println(Float.parseFloat("12.321"));
        String f4 = Float.toString(23.123f);
        System.out.println(f4.getClass());
        System.out.println(Float.toHexString(9.987f));

        System.out.println(Float.floatToIntBits(2.21f));
        System.out.println(Float.floatToRawIntBits(2.21f));
        System.out.println(Float.intBitsToFloat(21));
    }
}
