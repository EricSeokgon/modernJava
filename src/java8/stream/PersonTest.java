package java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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

    }


}