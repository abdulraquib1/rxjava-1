package lambdabasics;

public class SimpleLambda {

    public static void main(String[] args) {
        Printer printer = s -> System.out.println(s);
        printer.print("Hello to the world of Lamdba");

        Addition addition = (int a, int b) -> a+b;
        System.out.println(addition.add(10,20));

        Divison divison = (int a, int b) -> {
            if(b == 0) return b;
            return a/b;
        };

        System.out.println(divison.divide(10,5));
    }

    interface Addition{
        public int add(int a, int b);

    }

    interface Printer{
        public void print(String s);

    }

    interface Divison{
        public int divide(int a, int b);

    }

}
