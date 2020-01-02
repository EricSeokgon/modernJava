package java8.stream;

import java.util.*;
import java.util.stream.Stream;

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
    }
}
