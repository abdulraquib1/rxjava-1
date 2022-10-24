package lambdabasics;

public class HelloWorldGreeting {

//    greetingFucntion = () -> System.out.println("Hello World");
//    doubleNumberFucntion = (int a) -> a * 2;
//    addFunction = (int a, int b) -> a + b;
//    divideFunction = (int a, int b) -> { if (b == 0) return b; return a/b;}
//    stringLenFunction = (String s) -> s.length();

    public static void main(String args[]){
        Greeting greeting = () -> System.out.println("Hello to the world of Lambdas");
        greeting.perform();

        Greeting innerClassGreetings = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello to the world using inner class");
            }
        };

        innerClassGreetings.perform();


    }


}
