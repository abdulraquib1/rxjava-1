package lambdabasics;

public class TypeInferenceExample {

    public static void main(String[] args) {
        printLambda(s->s.length());
    }

    public static void printLambda(StringLengthLambda sll) {
        System.out.println(sll.getLength("Hello Lambda"));
    }

    @FunctionalInterface
    interface StringLengthLambda{
        int getLength(String s);

    }
}
