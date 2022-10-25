package lambdabasics;

import testdata.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExamples {


    public static void main(String[] args) {


        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Caroll", 42),
                new Person("Thomas", "Caryle", 51),
                new Person("Charlotte", "Brante", 45),
                new Person("Matthew", "Arnold", 39)
        );

        //old way of iterating
        System.out.println("Using the loop method");
        for(int i  =0; i<personList.size(); i++){
            System.out.println(personList.get(i));
        }

        //using for each
        System.out.println("Using for each loop");
        for(Person p : personList){
            System.out.println(p);
        }

        System.out.println("Using lambda for each");
        personList.forEach(p-> System.out.println(p));
        //personList.forEach(System.out::println);


    }
}
