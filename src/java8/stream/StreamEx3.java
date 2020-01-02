package java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    }
}
