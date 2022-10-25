package lambdabasics;

import testdata.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Caroll", 42),
                new Person("Thomas", "Caryle", 51),
                new Person("Charlotte", "Brante", 45),
                new Person("Matthew", "Arnold", 39)
        );


        //Default way to pass a lambda expression
        //printConditionally(personList, p-> p.getLastName().startsWith("C"), p-> System.out.println(p));

        printConditionally(personList, p-> true, System.out::println);
        printConditionally(personList, p-> p.getLastName().startsWith("C"), System.out::println);

    }

    private static void printConditionally(List<Person> persons, Predicate<Person> condition, Consumer<Person> consumer){
        for(Person p: persons){
            if(condition.test(p)) {
                consumer.accept(p);
            }
        }
        System.out.println("===========================");
    }
}
