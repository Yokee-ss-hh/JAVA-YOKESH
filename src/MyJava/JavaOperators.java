package MyJava;

public class JavaOperators {
    public static void main(String[] args) {
        byte a1 = 21;
        short a2 = 2121;
        int a3 = 65432132;
        long a4 = 987654567834L;
        float a5 = 43.2342f;
        double a6 = 67.543456;
        char a7 = 'g';
        boolean a8 = true;

        // Arithmetic operations on byte, short results in int
        // If the operand is of compile-time type byte, short, or char
        // it is promoted to a value of type int by a widening primitive conversion
        // If either operand is of type double, the other is converted to double.
        // Otherwise, if either operand is of type float, the other is converted to float.
        // Otherwise, if either operand is of type long, the other is converted to long.
        // Otherwise, both operands are converted to type int

        System.out.println("---------Arithmetic Operators-----------");

        int b1 = a1+a2;
        System.out.println(b1);
        int b2 = a2-a1;
        System.out.println(b2);
        int b3 = a1+a1;
        System.out.println(b3);
        int b4 = a2+a2;
        System.out.println(b4);
        int b5 = a1*a2;
        System.out.println(b5);
        int b6 = a2/a1;
        System.out.println(b6);
        int b7 = a1*a1;
        System.out.println(b7);
        int b8 = a2/a2;
        System.out.println(b8);

        // characters to follow this!
        int b14 = a1+a7;
        System.out.println(b14);
        int b15 = a1+a7;
        System.out.println(b15);
        int b16 = a2+a7;
        System.out.println(b16);

        // (byte/short) +,-,*,/,% (int) = int
        int b9 = a1+a3;
        System.out.println(b9);
        int b10 = a2+a3;
        System.out.println(b10);
        int b11 = a1*a3;
        System.out.println(b11);
        int b12 = a3/a2;
        System.out.println(b12);
        int b13 = a3%a1;
        System.out.println(b13);

        // Similarly (byte/short) +,-,*,/,% (float/double/long) = float/double/long

        float c1 = a1+a5;
        System.out.println(c1);

        // int(+,-,*,/,%)float = float
        // double(+,-,*,/,%)float = double
        // int(+,-,*,/,%)long = long

        // Characters with float,double and long
        float f1 = a5+a7;
        System.out.println(f1);
        double f2 = a6+a7;
        System.out.println(f2);
        long f3 = a4+a7;
        System.out.println(f3);

        byte z1 = 21;
        z1++;
        System.out.println(z1);

        System.out.println("-----Division and Modulo operators------- ");
        System.out.println(12/2);
        System.out.println(-12/2);
        System.out.println(12/-2);
        System.out.println(-12/-2);
        System.out.println(0/2);
        System.out.println(12%2);
        System.out.println(-12%5);
        System.out.println(12%-5);
        System.out.println(-12%-5);
        System.out.println(0%2);

        System.out.println("---------------Logical Operators---------------");
        if(21%2 != 0 && 20%2==0){
            System.out.println("Hello");
        }
        if(!(2%2==0)){
            System.out.println("Ok");
        }
        if(2>3 || 3<4){
            System.out.println("Its ok");
        }

        System.out.println("--------------Comparison Operators---------------");
        System.out.println(2==2);
        System.out.println(2<3);
        System.out.println(5>3);
        System.out.println(2!=3);
        System.out.println(4<=4);
        System.out.println(10>=10);

        System.out.println("---------------Bitwise Operators---------------");
        System.out.println(2&3); // 0010 & 0011 = 0010 = 2
        System.out.println(2|3); // 0010 | 0011 = 0011 = 3
        System.out.println(2^3); // 0010 ^ 0011 = 0001 = 1
        System.out.println(5<<2); // 0101 << 2 = 5 *(2 power 2) = 20
        System.out.println(5>>2); // 5 / (2 power 2) = 1
        System.out.println(~5); // ~x = -(x+1) = -6
        }
}
