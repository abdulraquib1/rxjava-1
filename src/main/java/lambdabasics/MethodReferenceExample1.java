package lambdabasics;

public class MethodReferenceExample1 {

    public static void main(String[] args) {

        //1. standard method of implementing lambda through expression
        Thread t1 = new Thread(()-> System.out.println("Hello using lambda expression"));
        t1.start();

        //2. passing a function as input to the lambda. note this function is invoked via the runnable interface
        Thread t2 = new Thread(()-> printMessage());
        t2.start();

        //3. Passing function to lambda using a Class Name
        Thread t3 = new Thread(MethodReferenceExample1::printMessage);
        t3.start();

    }

    public static void printMessage(){
        System.out.println("hello");
    }
}
