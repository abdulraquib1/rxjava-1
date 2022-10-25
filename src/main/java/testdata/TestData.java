package testdata;

import testdata.Person;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<Person> personList = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Caroll", 42),
            new Person("Thomas", "Caryle", 51),
            new Person("Charlotte", "Brante", 45),
            new Person("Matthew", "Arnold", 39)
    );
}

