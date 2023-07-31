package MyJava;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Strings {
    public static <string> void main(String[] args) {
        String s1 = "yokesh";
        String s2 = "yokesh";
        String s3 = s1;
        String s4 = "java";
        String s5 = new String("yokesh");
        String s6 = new String("ok");

        System.out.println("------------equals() vs == --------------");
        // equals() checks content, == checks whether 2 strings are in same memory location / not

        System.out.println(s1 == s2); // due to string interning in string pool
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);

        System.out.println(s1 == s5); // false as s5 is formed by new keyword

        // String pool is a small memory space inside heap memory.
        // strings created using "new" keyword will be created outside the string pool but inside the
        // heap memory.
        // intern() method makes string to transfer strings located outside the string pool which
        // are inside the heap memory into the string pool

        s6.intern(); // This makes s6 transfer from heap -> string pool
        String s7 = new String("home").intern(); // Another way of interning

        System.out.println("--------------String Methods--------------");
        String name1 = "yokesh chowdary";
        String name2 = "yokesh chowdary";
        String name3 = "Yokesh Chowdary";
        String name4 = "ROOT";
        String name5 = "earth";

        System.out.println(name1.length());
        System.out.println(name1.getClass());

        System.out.println("-------equals() vs contentEquals()----------");
        // equals() checks whether 2 strings are of type "String" and both have same data in them
        System.out.println(name1.equals("yokesh")); // false
        System.out.println(name1.equals("yokesh chowdary")); // true
        // contentEquals() checks whether 2 variables has same content (or) not
        // The data type may be String / StringBuilder / StringBuffer / CharBuffer
        // That means, All data types those implements CharSequence interface can be used
        // on contentEquals()
        System.out.println("yokesh".contentEquals("yokesh")); // true
        System.out.println("yokesh".contentEquals(new StringBuilder("yokesh"))); // true
        System.out.println("yokesh".contentEquals(new StringBuffer("yokesh"))); // true
        System.out.println("--------------------------------------------------");


        System.out.println(name1 == name2); // true

        System.out.println(name1.compareTo(name2)); // 0 , as both strings are same and of same length

        System.out.println(name1.equalsIgnoreCase(name3));
        System.out.println(name2.compareToIgnoreCase(name3));

        System.out.println(name4.toLowerCase());
        System.out.println(name5.toUpperCase());

        System.out.println(name1.charAt(3));
        System.out.println(name1.contains("ok"));

        String name6 = "madam is madam";
        System.out.println(name6.indexOf("m"));
        System.out.println(name6.indexOf("is"));
        System.out.println(name6.indexOf("m", 2));
        System.out.println(name6.indexOf("mad", 6));
        System.out.println(name6.lastIndexOf("m"));
        System.out.println(name6.lastIndexOf("m", 5));
        System.out.println(name6.lastIndexOf("madam"));
        System.out.println(name6.lastIndexOf("madam", 5));

        String name7 = "will come for sure";
        System.out.println(name7.startsWith("will"));
        System.out.println(name7.endsWith("sure"));

        String[] splittedStrings1 = name7.split(" ");
        for (String s : splittedStrings1) {
            System.out.println(s);
        }

        String[] splittedStrings2 = name7.split("f");
        for (String s : splittedStrings2) {
            System.out.println(s);
        }

        System.out.println("-------strip() vs trim()-----------");
        // Both are used to remove trailing and leading white spaces from a string
        // trim() is old and uses ascii for finding and removing white spaces
        // strip() is new and uses unicodes for finding and removing white spaces
        String name8 = " how are you   ";
        String strip1 = name8.strip();
        String strip2 = name8.stripLeading();
        String strip3 = name8.stripTrailing();
        System.out.println(strip1);
        System.out.println(strip2);
        System.out.println(strip3);

        String trim1 = name8.trim();
        System.out.println(trim1);
        // The problems comes when string contains unicodes
        String unicode_string = "\u2005 John Doe \u2005";
        System.out.println(unicode_string.strip()); // "John Doe" because strip() detects unicode
        System.out.println(unicode_string.trim()); // " John Doe " because trim() can't detect unicodes

        System.out.println(name8.substring(5, 9));

        String name9 = "how far we got came";
        System.out.println(name9.replace('c', 'C'));
        System.out.println(name9.replace("got", ""));

        String name10 = "oh my god oh, We are in oh";
        System.out.println(name10.replaceFirst("o", "O"));
        System.out.println(name10.replaceFirst("oh", "OH"));

        System.out.println("---------chars() and toCharArray()-----------");
        String name11 = "William john";
        IntStream intstream1 = name11.chars();
        intstream1.forEach(x -> System.out.println(x));
        //  chars() returns IntStream() which converts every character to its ascii equivalent
        // To get characters array instead of integers, use type conversion from integer to character
        IntStream intstream2 = name11.chars();
        intstream2.forEach(x-> System.out.println((char)x));

        System.out.println(Arrays.toString(name11.toCharArray()));

        System.out.println("--------concat() and '+' ----------");
        String c1 = "cat";
        String c2 = "meow";
        System.out.println(c1.concat(c2));
        System.out.println("cat"+"meow");

        System.out.println("---------codePoints,codePointAt,codePointBefore,codePointCount-------------");
        // All these methods returns unicode values of characters at that particular index
        String cp = "milkyway galaxy";
        System.out.println(cp.codePointAt(3));
        System.out.println(cp.codePointBefore(3));
        System.out.println(cp.codePointCount(4,8));
        // codePointCount() takes 2 indexes as input and count the number of characters
        // in between these 2 indexes and returns the count
        // codePoints() returns IntStream after converting the characters into respective ASCII values
        IntStream iS = cp.codePoints();
        iS.forEach(x-> System.out.println(x));
        // If we want to print the characters instead of ascii, Just type cast before printing
        // as, System.out.println((char)x);

        System.out.println("-----------repeat() and getChars()-----------");
        System.out.println("madam".repeat(2));
        System.out.println("madam".repeat(6));

        String s = "Hello World";
        char[] ch = new char[s.length()];
        s.getChars(0,s.length(),ch,0);
        String new_string = new String(ch);
        System.out.println(new_string);

        System.out.println("---------isBlank() and isEmpty()----------");
        // isBlank() checks whether string object is empty, null, whitespace and returns true
        // isEmpty() is same as isBlank() except it won't return true for whitespaces
        String p1= "yokesh";
        String p2= "   ";
        String p3 = "";
        System.out.println(p1.isBlank());
        System.out.println(p2.isBlank());
        System.out.println(p3.isBlank());
        System.out.println(p1.isEmpty());
        System.out.println(p2.isEmpty());
        System.out.println(p3.isEmpty());
    }
}
