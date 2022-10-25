package lambdabasics;

import testdata.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ComparatorWithFunctionalInterface {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Caroll", 42),
                new Person("Thomas", "Caryle", 51),
                new Person("Charlotte", "Brante", 45),
                new Person("Matthew", "Arnold", 39)
        );

        //step 1 : sort people by lastname
        Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));


        //step 2 : a method to print all the elements in the list
        printConditionally(personList, p-> true, p-> System.out.println(p));

        //step 3 : print all the people with the lastname starting with 'C'
        printConditionally(personList, p-> p.getLastName().startsWith("C"), p-> System.out.println(p));

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
