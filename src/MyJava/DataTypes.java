package MyJava;

public class DataTypes {
    public static void main(String[] args) {
        // -------------Primitive data types---------------
        // ---------Boolean-----------
        // boolean -> true | false -> default = false -> 1 bit signed
        // ---------Numeric Integers------------
        // byte -> 1 byte signed -> -2pow7 to 2pow7-1 -> default = 0
        // short -> 2 bytes signed -> -2pow15 to 2pow-1 -> default = 0
        // int -> 4 bytes signed -> -2pow31 to 2pow31-1 -> default = 0
        // long -> 8 bytes signed -> -2pow63 to 2pow63-1 -> default = 0
        // ---------Numeric Floating--------------
        // float -> 4 bytes -> default = 0.0
        // double -> 8 bytes -> default = 0.0
        // -----------Character-----------------
        // char -> 2 bytes Unsigned unicodes ranges from 0 to 2pow16-1
        // char unicodes range -> \u0000 to \uFFFF
        //-------------------------------------------------------------
        // Widening casting: Automatic type conversion as,
        // byte -> short -> char -> int -> long -> float -> double
        // Narrowing casting: Manual type conversion
        // double -> float -> long -> int -> char -> short -> byte

        byte b = 100;
        short s = 2222;
        int i = 76237162;
        long l = 2127718444444L;
        float f = 321.6279619F;
        double d = 4431.2343434314777D;
        // By default, floating point numbers without 'F' in them java treats it as Double data type
        // If I give float f = 432.32; It raises error as f is of type float but 432.32 is double type, so it asks
        // to cast down it.
        // So always write 'F' when initializing a floating number -> float f = 432.32F;
        // For double value initializing, Writing 'D' is optional
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println("-------------------------");
        // Assign byte to all other types
        short s1 = b;
        int i1 = b;
        long l1 = b;
        float f1 = b;
        double d1 = b;
        System.out.println(s1);
        System.out.println(i1);
        System.out.println(l1);
        System.out.println(f1);
        System.out.println(d1);
        System.out.println("----------------------------");
        // Assign short to all other types
        byte b2 = (byte) s;
        int i2 = s;
        long l2 = s;
        float f2 = s;
        double d2 = s;
        System.out.println(b2);
        System.out.println(i2);
        System.out.println(l2);
        System.out.println(f2);
        System.out.println(d2);
        System.out.println("---------------------------------");
        // Assign int to all other types
        byte b3 = (byte)i;
        short s3 = (short)i;
        long l3 = i;
        float f3 = i;
        double d3 = i;
        System.out.println(b3);
        System.out.println(s3);
        System.out.println(l3);
        System.out.println(f3);
        System.out.println(d3);
        System.out.println("----------------------------------");
        // Assign long to all other types
        byte b4 = (byte)l;
        short s4 = (short)l;
        int l4 = (int)l;
        float f4 = (int)l;
        double d4 = l;
        System.out.println(b4);
        System.out.println(s4);
        System.out.println(l4);
        System.out.println(f4);
        System.out.println(d4);
        System.out.println("--------------------------------");
        // Assign float to all
        byte b5 = (byte)f;
        short s5 = (short)f;
        int i5 = (int)f;
        long l5 = (long)f;
        double d5 = f;
        System.out.println(b5);
        System.out.println(s5);
        System.out.println(i5);
        System.out.println(l5);
        System.out.println(d5);
        System.out.println("----------------------------------");
        // Assign double to all
        byte b6 = (byte)d;
        short s6 = (short)d;
        int i6 = (int)d;
        long l6 = (long)d;
        float f6 = (float)d;
        System.out.println(b6);
        System.out.println(s6);
        System.out.println(i6);
        System.out.println(l6);
        System.out.println(f6);
        System.out.println("--------------------------------------");
        // Dealing with char data type and it's conversions with other data types
        // https://www.ssec.wisc.edu/~tomw/java/unicode.html
        // We can assign to character data type from 0 to 65535
        char c = 123;
        System.out.println(c);
        char c1 = 0;
        char c2 = 65535;
        System.out.println(c1);
        System.out.println(c2);
        // We can assign characters directly as,
        char c3 = '?';
        System.out.println(c3);
        int c4 = c3;
        System.out.println(c4); // ? = 63 in decimal in java unicode chart
        float c5 = c3;
        System.out.println(c5);
        char c6 = (char) 43.34f;
        System.out.println(c6);
        float c7 = c3; // c3 is '?' so java changes it to decimal = 63 and converts to float = 63.0
        System.out.println(c7);
        float c8 = 321.43F;
        char c9 = (char)c8; // converts 321.43F to 321 which is a decimal in unicode chart and returns it
        System.out.println(c9);
        System.out.println("-------------------------------------");
        // How java does narrowing casting:
        int y1 = 888;
        byte y2 = (byte)y1;
        // 888 is int of size 4 bytes = 00000000 00000000 00000011 01111000
        // byte is 1 byte = 8 bits so take last 8 bits from above = 01111000 = sign bit + 1111000
        // 111100 = +120, and it is in short data type range, so it is the answer
        // +120 = 120
        System.out.println(y2); // 120
        int y3 = 562371;
        short y4 = (short)y3;
        // 562371 = 00000000 00001000 10010100 11000011
        // short has 2 bytes size so take 2 bytes from above = 10010100 11000011 = sign bit + 0010100 11000011
        // 0010100 11000011 = -5315
        // -5315 is not in short data type range and it is close to -2pow15 so add 5315 to -2pow15 to get answer
        // -pow(2,15) + 5315 = -27453
        System.out.println(y4); // -27453
        long y5 = 721641661L;
        short y6 = (short)y5;
        // 721641661 represented in 8 bytes as,
        // 00000000 00000000 00000000 00000000 00101011 00000011 01100000 10111101
        // short takes 2 bytes = 01100000 10111101 = sign bit + 1100000 10111101
        // 1100000 10111101 = 24765 is in the range of short, so it is the answer
        System.out.println(y6);// 24765
        long y7 = 40002;
        short y8 = (short)y7;
        // 40002 in 8 bytes as
        // 00000000 00000000 00000000 00000000 00000000 00000000 10011100 01000010
        // Take 10011100 01000010
        // sign bit + 0011100 01000010
        // 0011100 01000010 = -7234 including sign
        // -7234 is not in range of short
        // -2pow15+7234 = -25534 is the answer
        System.out.println(y8); // -25534
        // Casting floating (or) double values which are not in range of int, long data types to int, long
        // will store their respective minimum and maximum ranges.
        float y9 = -6814717231723717765432.432F;
        int y10 = (int)y9;
        System.out.println(y10); // Prints the minimum range for int data type i.e, -2147483648
        float y11 = 6814717231723717765432.432F;
        int y12 = (int)y11;
        System.out.println(y12); // Prints the maximum range for int data type i.e, 2147483647
        // Similarly for long data types
        long y13 = (long)y9;
        System.out.println(y13); // prints the minimum range for long data type i.e, -9223372036854775808
        long y14 =(long)y11;
        System.out.println(y14); // prints the maximum range for long data type i.e, 9223372036854775808
    }
}
