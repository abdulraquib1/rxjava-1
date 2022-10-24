package lambdabasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorWithLambdaExercise {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Caroll", 42),
                new Person("Thomas", "Caryle", 51),
                new Person("Charlotte", "Brante", 45),
                new Person("Matthew", "Arnold", 39)
        );

        //step 1 : sort people by lastname
        Collections.sort(personList, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));


        //step 2 : a method to print all the elements in the list
        printConditionally(personList, p-> true);

        //step 3 : print all the people with the lastname starting with 'C'
        printConditionally(personList, p-> p.getLastName().startsWith("C"));

    }

    private static void printConditionally(List<Person> persons, MyCondition condition){
        for(Person p: persons){
            if(condition.test(p)) {
                System.out.println(p);
            }
        }
        System.out.println("===========================");
    }


}

interface MyCondition{
    boolean test(Person p);

}
