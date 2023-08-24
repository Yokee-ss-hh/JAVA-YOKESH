package DesignPatterns.CreationalDP;

// Eager Initialization:
// Object of a class is created when the class is loaded in the memory by Jvm
// This initialization is done by assigning instance of class directly to a variable
// object is created always even when there is no need
// wastage of cpu resources
class SinglePattern1{
    // private so that this is not accessible directly outside the class
    // static so that it can be created when class is loaded in memory by jvm
    private static SinglePattern1 sp1 = new SinglePattern1();

    // private constructor so that this constructor cannot be called outside the class
    // If a class constructor is private, (We cannot create a subclass of a class whose constructor is private)
    // Even if we create a subclass we need to call
    // super() from subclass which is not possible due to private constructor, So private
    // constructor is mandatory.
    private SinglePattern1(){}

    public static SinglePattern1 getSp1(){
        return sp1;
    }
}

// Lazy Initialization:
// Object of a class will be created whenever it is needed
// There will be no wastage of cpu resources if user don't want the object
class SinglePattern2{
    private static SinglePattern2 sp2 = null;
    private SinglePattern2(){}
    public static SinglePattern2 getSp2(){
        if(sp2 == null){
            sp2 = new SinglePattern2();
        }
        return sp2;
    }
    // Issues comes when the above executes in multithreaded environments
    // Let's say there are 2 threads t1 and t2 running in parallel/ in concurrent processors
    // When t1 starts execution and encounters sp2 == null in method, t1 will
    // instantiate object, Before t1 instantiate if t2 gets chance of accessing method, it will
    // get true when it encounters sp2 == null, as t1 didn't instantiate yet, so there will be 2
    // objects gets created when t1 and t2 execution completes, which violate singleton design p
    // pattern.
}

// The above lazy initialization is not thread safe, so the below implementation is thread safe
class SinglePattern3{
    private static volatile SinglePattern3 sp3 = null;
    private SinglePattern3(){}

    public static SinglePattern3 getSp3(){
        synchronized (SinglePattern3.class) {
            if (sp3 == null) {
                sp3 = new SinglePattern3();
            }
            return sp3;
        }
    }
    // if 2 threads are from different processors, then each thread gets a copy of application data from
    // main memory which stores in the local memory which is created for the process in which the thread
    // is running. If t1 updates some data, those changes will be restricted to that local memory of the
    // process. Those changes will not be synced to main memory. That will create a problem when thread t2
    // has un updated data in its local process memory. If we want our data to be synced with main memory
    // when some threads change them, We need to use volatile such that that resource will always be synced
    //  with main memory.
    // synchronized() block ensures that only 1 thread is executed the if condition before proceeding
    // to create an object.
}
// There is a performance issue with the above code
// Let's say t1 thread started execution and encounters sp3 == null in if condition.
// t1 creates an object and assigns to sp3 and t1 is doing some operation after creating object.
// Let's say t2 thread gets access for method and t2 starts executing method, Even though object is
// initialized by t1 thread, t2 cannot check if condition due to synchronized block. If synchronized
// block starts after if condition, Then t2 would not wait for t1 thread to give up the lock and
// t2 can check the if condition and if condition will fail as t1 thread created object and t2 directly
// moves to return sp3 statement, and it gets object.


// The below strategy is called DCL(Double-Checked-Locking)
class SinglePattern4{
    private static volatile SinglePattern4 sp4 = null;
    private SinglePattern4(){}
    public static SinglePattern4 getSp4(){
        if (sp4 == null) {
            synchronized (SinglePattern4.class){
                sp4 = new SinglePattern4();
            }
        }
        return sp4;
    }
}
public class SingletonDesignPattern {
    public static void main(String[] args) {
        SinglePattern1 s1 = SinglePattern1.getSp1();
        SinglePattern1 s2 = SinglePattern1.getSp1();
        System.out.println(s1.hashCode() == s2.hashCode());

        SinglePattern2 s3 = SinglePattern2.getSp2();
        SinglePattern2 s4 = SinglePattern2.getSp2();
        System.out.println(s3.hashCode() == s4.hashCode());

        SinglePattern3 s5 = SinglePattern3.getSp3();
        SinglePattern3 s6 = SinglePattern3.getSp3();
        System.out.println(s5.hashCode() == s6.hashCode());

        SinglePattern4 s7 = SinglePattern4.getSp4();
        SinglePattern4 s8 = SinglePattern4.getSp4();
        System.out.println(s7.hashCode() == s8.hashCode());
    }
}
