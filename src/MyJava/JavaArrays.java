package MyJava;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class JavaArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4}; // declaration and initialization
        int []arr2 = {1,2,3}; // declaration and initialization
        int arr3[] = {1,2,3,4,5}; // declaration and initialization
        int[] arr5 = new int[3]; // declaration
        arr5[0] = 0;
        arr5[1] = 1;
        arr5[2] = 2;
        String[] arr6 = {"one","two","three"};

        System.out.println(Arrays.toString(arr1));

        for(int x: arr1){
            System.out.print(x);
        }
        System.out.println("\n");
        for(int i=0; i<arr2.length;i++){
            System.out.print(arr2[i]);
        }
        System.out.println("\n");

        System.out.println("---------------Arrays asList--------------------------");
        // The type of array must be a Wrapper Class(Integer,Float, etc) in case of primitive data types(int, float,etc)
        // You can’t pass int a[] but you can pass Integer a[].
        // If you pass int a[], this function will return a  List <int a[]> and not List <Integer> , as “autoboxing”
        // doesn’t happen in this case and int a[] is itself identified as an object and a List of int array is returned,
        // instead of list of integers , which will give error in various Collection functions .
        Integer[] someArray = {2,4,5,8,22};
        // Arrays.asList() returns a List data structure specifically ArrayList.
        List<Integer> al = Arrays.asList(someArray);
        System.out.println(al);
        // Now "al" is of fixed size which is the size of length of the array
        // So, we cannot use List methods such as add() to "al" which raises java.lang.UnsupportedOperationException
        List<Float> al1 = Arrays.asList(1.32f,2.321f,7.564f);
        System.out.println(al1);

        System.out.println("---------------Array fill()-----------------");
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        boolean[] array3 = new boolean[5];
        Arrays.fill(array1,1);
        Arrays.stream(array1).forEach(x-> System.out.print(x));
        System.out.print("\n");
        Arrays.fill(array2,2,5,5);
        Arrays.stream(array2).forEach(x-> System.out.print(x));
        System.out.print("\n");
        Arrays.fill(array3,0,2,true);
        for(boolean b : array3){
            System.out.print(b);
        }
        System.out.print("\n");
        // Similarly fill() is available for byte,long,short,float,boolean,double and Object arrays
        // NOTE: If array size is 6 elements, and we filled only 3 elements using a value,
        // The remaining elements are filled by their default values of type of array.

        System.out.println("------------------Arrays sort-------------");
        float[] array4 = {9.2f,2.3f,3.4f};
        Arrays.sort(array4);
        for(float f: array4){
            System.out.println(f);
        }
        System.out.print("\n");

        int[] array5 = {46,23,-32,123,432,0};
        Arrays.sort(array5,2,5);
        for(int i:array5){
            System.out.println(i);
        }
        System.out.print("\n");

        Integer[] array6 = {0,-21,32,4321,12,-12};
        Arrays.sort(array6, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(Arrays.toString(array6));
        // All the above 3 methods of sorting is applicable to byte, short, int, long, float, double and Object

        System.out.println(Arrays.toString(new int[]{1,2,3,4,5}));
        // toString() is applicable for int, float, long, double, char, boolean, byte, short and Object

        System.out.println("----------------Arrays binarySearch()-----------------");
        Integer[] array7 = {1,2,3,4,5};
        System.out.println(Arrays.binarySearch(array7,3));
        System.out.println(Arrays.binarySearch(array7,2,5,30));
        // if key is not found it returns -(low+1)
        System.out.println(Arrays.binarySearch(array7, 5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }));
        System.out.println(Arrays.binarySearch(array7, 3,5,5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }));
        // All the above 4 types of binary search is applicable for
        // int, byte, short, long, float, double, char and Object

        System.out.println("------------clone(), Arrays copyOf() and Arrays copyOfRange()--------------");
        // Arrays.copy() and Arrays.copyOfRange() creates new array
        // == operator returns false when tested
        // Similarly, clone() creates new array

        int[] original = {1,2,3};
        int[][] original2 = {{1,2},{3,4}};
        int[] o1 = original.clone();
        int[][] o2 = original2.clone();
        System.out.println(original == o1); // false
        System.out.println(original.equals(o1)); // false
        System.out.println(Arrays.equals(original,o1)); // true
        System.out.println(original2 == o2); // false
        System.out.println(original2.equals(o2)); // false
        System.out.println(Arrays.equals(original2,o2)); // true

        int[] o3 = Arrays.copyOf(original,original.length);
        int[][] o4 = Arrays.copyOf(original2, original2.length);
        System.out.println(o3 == original); // false
        System.out.println(o3.equals(original)); // false
        System.out.println(Arrays.equals(original,o3)); // true
        System.out.println(o4 == original2); // false
        System.out.println(o4.equals(original2)); // false
        System.out.println(Arrays.equals(original2,o4)); // true

        int[] array8 = {1,2,3,4,5};
        int[] copied_array1 = Arrays.copyOf(array8,array8.length);
        System.out.println(Arrays.toString(copied_array1));
        int[] copied_array2 = Arrays.copyOf(array8,11);
        System.out.println(Arrays.toString(copied_array2));
        // If array length we specify is more than copy array, then they are filled with default
        // type of array
        float[] array9 = {1.2f,2.3f,3.4f};
        float[] copied_array3 = Arrays.copyOf(array9,8);
        System.out.println(Arrays.toString(copied_array3));
        // similarly copyOfRange() also works
        int[] copied_array4 = Arrays.copyOfRange(array8,1,7);
        System.out.println(Arrays.toString(copied_array4));
        char[] array10 = {'a','b','c'};
        char[] copied_array5 = Arrays.copyOfRange(array10,0,5);
        System.out.println(Arrays.toString(copied_array5));
        // If to position is greater than length of original array, then the empty
        // positions will be filled with original array types default value
        // copyOf() and copyOfRange() works for int, byte, short, long, float, double, char, boolean and Object

        System.out.println("-----------equals(), ==, Arrays.equals(o1,o1)-----------------");
        // Differences b/w equals(), "==" and Arrays.equals()

        // array1.equals(array2):
        // In this case, the array1 is not an object so, it cannot override Object.equals() to implement
        // its own equals() method. So it checks whether both arrays have same reference
        int[] v1 = {1,2,3};
        int[] v2 = v1;
        int[] v3 = {1,2,3};
        int[][] v4 = {{1,2},{3,4}};
        int[][] v5 = {{1,2},{3,4}};

        System.out.println(v1.equals(v2)); // true
        System.out.println(v1.equals(v3)); // false
        System.out.println(v2.equals(v3)); // false

        System.out.println(v1==v2); // true
        System.out.println(v1==v3); // false
        System.out.println(v2==v3); // false

        // Arrays.equals(array1,array2):
        // In this case Object.equals() method is overrided and re-implemented by Arrays class
        // It checks whether both arrays have same content or not
        System.out.println(Arrays.equals(v1,v2));
        System.out.println(Arrays.equals(v1,v3));
        System.out.println(Arrays.equals(v2,v3));

        // Arrays.equals() will not work correctly for 2-D arrays, so use Arrays.deepEquals()
        // Arrays.deepEquals() works on 1-D arrays as well
        System.out.println(Arrays.equals(v4,v5)); // false
        System.out.println(Arrays.equals(v1,v3)); // true
        System.out.println(Arrays.deepEquals(v4,v5)); // true

        // Arrays.equals(array1,start,stop,array2,start,stop)
        int[] v6 = {1,2,3,4};
        int[] v7 = {1,2,3,4,5,6};
        System.out.println(Arrays.equals(v6,1,3,v7,1,3));

        int[][] v8 = {{1,2},{3,4}};
        int[][] v9 = {{1,2,3}, {3,4,5}};
        System.out.println(Arrays.equals(v8[0],0,2,v9[0],0,2));

        // There is no support for start and stop index for deepEquals() method

        // equals() and deepEquals() supports arrays of byte, short, int, long, float, double, char,
        // boolean, Object and T[] types

        System.out.println("-------------Arrays mismatch()------------------");
        // Returns index of first mismatch of element in 2 arrays
        // If there is no mismatch, it returns -1
        int[] z1 = {1,2,3,4,5,12,13,21};
        int[] z2 = {1,2,3,4,5,7,9,12};
        System.out.println(Arrays.mismatch(z1,z2));
        System.out.println(Arrays.mismatch(z1,0,4,z2,0,4));
        // The above 2 methods works for byte, short, int, long, float, double, char, boolean and Object types

        System.out.println("--------------Arrays parallelPrefix-----------------");
        // This method performs operations on array elements with a current element and a previous element.
        int[] ap1 = {1,2,3};
        int[] ap11 = {3,4,5,6};
        IntBinaryOperator ibo = ( x , y) -> x+y;
        Arrays.parallelPrefix(ap1,ibo); // overload 1
        Arrays.parallelPrefix(ap11,1,3,ibo); // overload 2
        System.out.println(Arrays.toString(ap1));
        System.out.println(Arrays.toString(ap11));

        long[] ap2 = {28714717234L,32413412343212L,9846143187301L};
        long[] ap22 = {873172318381203192L, 73087207182L, 3173812381893L, 67611747178L};
        LongBinaryOperator lbo = (x,y)->x+y;
        Arrays.parallelPrefix(ap2,lbo); // overload 1
        Arrays.parallelPrefix(ap22,1,3,lbo);
        System.out.println(Arrays.toString(ap2));
        System.out.println(Arrays.toString(ap22));

        double[] ap3 = {28714717234.231,32413412343.212,984614318.7301};
        double[] ap33 = {2874214717234.231,3242413412343.212,92384614318.7301, 64871741774.6742364};
        DoubleBinaryOperator dbo = (x,y)->x+y;
        Arrays.parallelPrefix(ap3,dbo); // overload 1
        Arrays.parallelPrefix(ap33,1,3,dbo); // overload 2
        System.out.println(Arrays.toString(ap3));
        System.out.println(Arrays.toString(ap33));

        // There is a support for 3 types of binary operators directly from parallelPrefix() method,
        // For others use BinaryOperator<T>
        Character[] ap4 = {'a','b','c','d'};
        BinaryOperator<Character> doc = (x, y)-> (char) ((char)x+(char)y);
        Arrays.parallelPrefix(ap4,doc);
        System.out.println(Arrays.toString(ap4));

        Float[] ap5 = {1.2f,3.45f,4.5432f,54.3456f,6.5435f};
        Float[] ap55 = {1.2f,3.45f,4.5432f,54.3456f,6.5435f};
        BinaryOperator<Float> bof = (x,y)->x*y;
        Arrays.parallelPrefix(ap5,bof);
        Arrays.parallelPrefix(ap55,1,4,bof);
        System.out.println(Arrays.toString(ap5));
        System.out.println(Arrays.toString(ap55));

        // parallelPrefix() is only available for int, long and double primitive arrays
        // For more support we need to use T[] and T<TYPE>
        System.out.println("------------------parallelSort()----------------------");
        // 1. The array is divided into sub-arrays and that
        //   sub-arrays is again divided into their sub-arrays,
        //   until the minimum level of detail in a set of array.
        //2. Arrays are sorted individually by multiple thread.
        //3. The parallel sort uses Fork/Join Concept for sorting.
        //4. Sorted sub-arrays are then merged.
        int[] y1 = {9,99,75,1,0,-23};
        Arrays.parallelSort(y1); // overload 1
        System.out.println(Arrays.toString(y1));

        float[] y2 = {3.23f,9.87654f,2312.4234f,-9.8765f,0.0f};
        Arrays.parallelSort(y2,1,5); // overload 2
        System.out.println(Arrays.toString(y2));

        Boolean[] y3 = {true,false,false,true};
        Arrays.parallelSort(y3);
        System.out.println(Arrays.toString(y3));

        // parallelSort() is available for byte, short, int, long, float, double, char and T[]

        System.out.println("-----------------Arrays compare()------------------------------");
        int[] x1 = {1,2,3,4,5};
        int[] x2 = {1,2,3,4};
        System.out.println(Arrays.compare(x1,x2)); // overload 1
        System.out.println(Arrays.compare(x1,0,4,x2,0,4)); // overload 2

        int[] x3 = {1,2,3};
        int[] x4 = {4,5,6};
        System.out.println(Arrays.compare(x3,x4));

        // Similarly Arrays.compare() works for byte, short, int, long, float, double, boolean, char and T[]

        System.out.println("----------Arrays hashCode() and Arrays deepHashCode()-----------");
        int[] h1 = {2,3,5,7,9};
        int[][] h2 = {{1,3,5},{7,9,11}};
        System.out.println(Arrays.hashCode(h1));
        System.out.println(Arrays.hashCode(h2));

        Integer[] h3 = {32,321,23,65};
        Integer[][] h4 = {{23,43,6543},{6456,5535,4234234,3423423}};
        System.out.println(Arrays.hashCode(h3));
        System.out.println(Arrays.deepHashCode(h3));
        System.out.println(Arrays.hashCode(h4));
        System.out.println(Arrays.deepHashCode(h4));

        System.out.println("------------setAll() and parallelSetAll() methods------------------");
        // setAll() supports Integer, Long and Double directly with methods
        int[] sa1 = {1,2,3,4,5};
        int[] sa2 = {6,3,1,8,4};

        IntUnaryOperator i1 = e -> {
          if(e % 2 == 0){
              return e*e;
          }
          else{
              return e;
          }
        };
        Arrays.setAll(sa1,i1);
        System.out.println(Arrays.toString(sa1));

        // Another way to do this
        Arrays.setAll(sa2, e->{
            if(e%2==0){
                return e*e;
            }
            else{
                return e;
            }
        });
        System.out.println(Arrays.toString(sa2));

        // For Long and Double types use LongUnaryOperator and DoubleUnaryOperator
        // parallelSetAll() is faster than setAll() but both has same functionalities
    }
}
