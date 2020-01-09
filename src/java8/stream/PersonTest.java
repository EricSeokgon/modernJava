package java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void person등록() {
        List<Person> person = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("david", 12));

        List<Person> filtered = person.stream()
                .filter(p -> p.getName().startsWith("P"))
                .collect(Collectors.toList());


        Map<Integer, List<Person>> personByAge = person.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));
        System.out.println(personByAge);

        Double averageAge = person.stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println(averageAge);

        IntSummaryStatistics ageSummary = person.stream()
                .collect(Collectors.summarizingInt(p -> p.getAge()));
        System.out.println(ageSummary);

        person.stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getName())
                .collect(Collectors.joining(" and ", "In Germany ", " are o flegal age."));

        Map<Integer, String> map = person.stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2
                ));

        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
                () -> new StringJoiner(" | "),
                (j, p) -> j.add(p.getName().toUpperCase()),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString);

        String names = person.stream()
                .collect(personNameCollector);
        System.out.println(names);

    }


}