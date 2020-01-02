package java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("jeong", "pro", "jdk", "Java");
        //기존 코딩 방식
        long count = 0;
        for (String name : names) {
            if (name.contains("o")) {
                count++;
            }
        }
        System.out.println("Count : " + count);

        //스트림 이용한 방식
        count = 0;
        count = names.stream().filter(x -> x.contains("o")).count();
        System.out.println("Count : " + count);

    }
}
