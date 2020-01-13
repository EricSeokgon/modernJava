package java8.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceEx {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("david", 12));

        persons.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(System.out::println);

        Person result = persons.stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.setAge(p2.getAge());
                    p1.setName(p2.getName());
                    return p1;
                });

        System.out.format("name=%s; age=%s", result.getName(), result.getAge());


    }
}
