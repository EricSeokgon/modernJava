package java8.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

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
        System.out.println();

        Integer ageSum = persons.stream()
                .reduce(0, (sum, p) -> sum += p.getAge(), (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum);

        Integer ageSum1 = persons.stream()
                .reduce(0, (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person%s\n", sum, p);
                            int age = p.getAge();
                            return sum += age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

        Integer ageSum2 = persons.parallelStream()
                .reduce(0, (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person%s\n", sum, p);
                            int age = p.getAge();
                            return sum += age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: 5s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .sorted((s1, s2) -> {
                    System.out.format("sort: %s <> %s[%s]\n", s1, s2, Thread.currentThread().getName());
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.format("forEach : %s [%s]\n", s, Thread.currentThread().getName()));


    }
}
