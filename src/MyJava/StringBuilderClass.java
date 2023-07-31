package MyJava;

import java.util.stream.IntStream;

public class StringBuilderClass {
    public static void main(String[] args) {
        // StringBuilder class makes String object mutable
        // Empty StringBuilder object has maximum capacity of 16 characters
        // ---Below are StringBuilder constructors----
        // StringBuilder() -> Initial capacity of 16 characters
        // StringBuilder(int capacity) -> User can give capacity
        // StringBuilder(CharSequence sequence)
        StringBuilder sb1 = new StringBuilder("hello");
        System.out.println(sb1);
        System.out.println(sb1.getClass());
        System.out.println(sb1.toString());
        System.out.println(sb1.toString().getClass());
        System.out.println(sb1.capacity()); // 21 because 16+5 characters added
        System.out.println(sb1.length());


        System.out.println("-------append and it's overloads--------------");
        // As by default StringBuilder has a size of 16 characters, But we can provide new size as,
        StringBuilder sb2 =  new StringBuilder(60);
        System.out.println(sb2.capacity());
        sb2.append(12);
        System.out.println(sb2);
        System.out.println(sb2.getClass());
        System.out.println(sb2.capacity());
        sb2.append('f');
        sb2.append(12.22f);
        sb2.append(23.2321);
        sb2.append(3131231321L);
        sb2.append(true);
        sb2.append(new char[]{'a','b'});
        sb2.append("yokesh");
        System.out.println(sb2);
        System.out.println(sb2.capacity());

        System.out.println("--------How string builder capacity grows---------");
        StringBuilder sb3 = new StringBuilder(10);
        // Until the data in StringBuilder object is <= to the capacity. The capacity
        // will not grow automatically. But, If data in SB object grows > than capacity
        // It grows as -> New capacity = (Old Capacity * 2) + 2
        sb3.append("yokeshhalo");
        System.out.println(sb3.capacity());
        // Now sb3 has capacity of exactly 10 and length of data in it also has exactly 10
        // Let's add 1 character and see length
        sb3.append('g');
        System.out.println(sb3.capacity()); // 22 is the new length
        // old = 10, new = (10*2)+2 = 22
        sb3.append(123456789101L);
        System.out.println(sb3.capacity()); // new length = 46 -> Adding above long data added 12 characters
        // So The total data length is 23 characters that is > 22 , So new length is updated as
        // (22*2)+2 = 46

        System.out.println("---------------insert()----------------");
        StringBuilder sb4 = new StringBuilder(10);
        sb4.append("hello");
        sb4.insert(3,"G");
        System.out.println(sb4);

        System.out.println("------deleteCharAt() and deleteAt()-----------");
        StringBuilder sb5 = new StringBuilder("Nice");
        sb5.append("yokesh");
        System.out.println(sb5);
        sb5.delete(4,7);
        System.out.println(sb5);
        sb5.deleteCharAt(3);
        System.out.println(sb5);

        System.out.println("----indexOf() and lastindexOf()");
        StringBuilder sb6 = new StringBuilder("manspidermansolo");
        System.out.println(sb6.indexOf("s"));
        System.out.println(sb6.indexOf("man"));
        System.out.println(sb6.indexOf("s",5));
        System.out.println(sb6.lastIndexOf("o"));
        System.out.println(sb6.lastIndexOf("man",8));
        System.out.println(sb6.lastIndexOf("man"));

        System.out.println("----reverse() and replace()----");
        StringBuilder sb7 = new StringBuilder("makeit again");
        System.out.println(sb7.reverse());
        sb7.replace(2,5,"yokesh");
        System.out.println(sb7);

        System.out.println("-----compareTo(), charAt(), setCharAt()----");
        StringBuilder sb8 = new StringBuilder("yokesh");
        System.out.println(sb8.capacity()); // 22 -> 16 + length("yokesh")
        System.out.println(sb8.compareTo(new StringBuilder("yokesh")));
        System.out.println(sb8.charAt(4));
        sb8.setCharAt(5,'K');
        System.out.println(sb8);
        sb8.setLength(20); // sets new length to the data od StringBuilder object
        System.out.println(sb8.length()); // 20 but not 6, even though length of "yokesh" is 6

        System.out.println("---------chars()--------");
        StringBuilder sb9 = new StringBuilder("codepoint");
        IntStream int1 = sb9.chars();
        int1.forEach(x-> System.out.println(x));

        System.out.println("------codePointAt(),codePointBefore(),codePoints() and codePointCount() ");
        StringBuilder sb10 = new StringBuilder("magicmoments");
        System.out.println(sb10.codePointAt(4));
        System.out.println(sb10.codePointBefore(3));
        IntStream int2 = sb10.codePoints();
        int2.forEach(x -> System.out.println(x));
        System.out.println(sb10.codePointCount(3,7));

        System.out.println("---substring(), subsequence()-----");
        StringBuilder sb11 = new StringBuilder("helloworld");
        System.out.println(sb11.substring(3));
        System.out.println(sb11.substring(1,6));
        System.out.println(sb11.subSequence(3,6));

        System.out.println("--------getChars()----------");
        StringBuilder sb12 = new StringBuilder("Javaworld");
        char[] ch = new char[sb12.length()];
        sb12.getChars(0,sb12.length(),ch,0);
        System.out.println(sb12);
    }
}
