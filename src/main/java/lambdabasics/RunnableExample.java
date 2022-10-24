package lambdabasics;

public class RunnableExample {


    public static void main(String[] args) {

        //Thread using anonymous Function
        Thread myThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("print inside runnable");
            }
        });

         myThread1.start();

        //Thread using lambda implementation
        Thread myThread2 = new Thread(()-> System.out.printf("print inside runnable lamdba"));
        myThread2.start();
    }
}
