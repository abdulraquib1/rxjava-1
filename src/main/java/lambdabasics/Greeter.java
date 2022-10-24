package lambdabasics;

public class Greeter {
    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String args[]){

        Greeter greeter = new Greeter();

        //Multiple ways of invoking an interface
        //Method 1
        Greeting innerClassGreetings = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello to the world using inner class");
            }
        };

        greeter.greet(innerClassGreetings);

        //Method 2
        Greeting greeting = () -> System.out.println("Hello to the world of Lambdas");
        greeter.greet(greeting);

        //Method 3
        greeter.greet(()->System.out.println("Hello to the world of Lambdas"));



    }
}
