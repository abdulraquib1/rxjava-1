package lambdabasics;



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

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}