package java8.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.*;

public class StreamEx3 {
    public static void main(String[] args) {
        int[] numberArr = {1, 2, 3, 4, 5, 6};
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<Integer> numberSet = new HashSet<>(numberList);

        Arrays.stream(numberArr);
        Stream.of(1, 2, 3, 4, 5, 6);
        numberList.stream();
        numberSet.stream();

        //스트림 vs 컬렉션
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.get(0);
        numbers.remove(0);

        List<Integer> evenList = new ArrayList<>();

        for (int number : numberList) {
            if (number % 2 == 0) {
                evenList.add(number);
            }
        }
        System.out.println(evenList);

        List<Integer> iterate = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(iterate);

        Stream.iterate(1, n -> 1 + n)
                .limit(6)
                .peek(System.out::println) //스트림을 순회하며 하나씩 요소를 꺼내 출력하는 구문
                .filter(number -> number % 2 == 0);

        Stream<Integer> stream = Stream.iterate(1, n -> 1 + n)
                .limit(6)
                .peek(System.out::println) //스트림을 순회하며 하나씩 요소를 꺼내 출력하는 구문
                .filter(number -> number % 2 == 0);
        stream.collect(Collectors.toList());

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> peek = stream1.peek(System.out::println);

        peek.collect(Collectors.toList());

        Object obj = null;
        boolean b = 1 == 2 && obj.toString().equals(123);

        List<String> list = Arrays.asList("a", "b", "c");
        boolean b1 = list.stream().allMatch(str -> {
            System.out.println(str);
            return str.equals("d");
        });

        ArrayList<Object> list1 = new ArrayList<>();
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L);

        intStream.sum();

        List<Integer> collect = intStream.boxed().collect(Collectors.toList());

    }
}
