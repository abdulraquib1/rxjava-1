package streambasics;

import java.util.List;
import java.util.stream.Stream;

public class BasicStream {

    public static void main(String[] args) {

        List<testdata.Person> personList = testdata.TestData.personList;

        //personList.stream().forEach(p-> System.out.println(p));
        personList.stream()
                .filter(p->p.getLastName().startsWith("C"))  // filter
                .forEach(System.out::println);

        Stream<testdata.Person> myStream = personList.stream();


        //terminal operations
        long count = personList.stream()
                .filter(p->p.getLastName().startsWith("C"))
                  .count();

        System.out.println(count);

    }
}
