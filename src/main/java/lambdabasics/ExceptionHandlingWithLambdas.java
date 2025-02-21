package lambdabasics;

import java.util.function.BiConsumer;

public class ExceptionHandlingWithLambdas {

    public static void main(String[] args) {
        int[] someNumbers = {1,2,3,4};
        int key = 0;

        process(someNumbers, key, wrapperLambda((v,k) -> System.out.println(v / k)));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer,Integer> consumer){
        for(int number: someNumbers){
            //System.out.println(number);
            consumer.accept(number,key);
        }

    }

    private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
        return (v,k) -> {
            try {
                consumer.accept(v, k);
            }catch (ArithmeticException ex){
                System.out.println("Caught " + ex.getClass());
            }
        };
    }
}
