package lambdabasics;



import testdata.Person;

import java.util.*;

public class ComparatorExercise {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Caroll", 42),
                new Person("Thomas", "Caryle", 51),
                new Person("Charlotte", "Brante", 45),
                new Person("Matthew", "Arnold", 39)
        );

        //step 1 : sort people by lastname
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        //step 2 : a method to print all the elements in the list
        printAll(personList);
        //step 3 : print all the people with the lastname starting with 'C'
        printConditionally(personList, new Condition(){

            @Override
            public boolean test(Person p){
                return p.getLastName().startsWith("C");
            }
        });

    }

    private static void printAll(List<Person> persons){
        for(Person p: persons){
            System.out.println(p);
        }
        System.out.println("===========================");
    }

    private static void printConditionally(List<Person> persons, Condition condition){
        for(Person p: persons){
            if(condition.test(p)) {
                System.out.println(p);
            }
        }
        System.out.println("===========================");
    }


}

interface Condition{
    boolean test(Person p);

}

