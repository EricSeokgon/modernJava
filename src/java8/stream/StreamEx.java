package java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {

        //Stream 사용전
        String[] strArr = {"mash-up", "backend", "codingsquid"};
        List<String> strList = Arrays.asList(strArr);

        Arrays.sort(strArr);
        Collections.sort(strList);

        for (String str : strArr) {
            System.out.println(str);
        }
        for (String str : strList) {
            System.out.println(str);
        }

        //Stream 사용 후
        Stream<String> listStream = strList.stream();
        Stream<String> arrayStream = Arrays.stream(strArr);

        listStream.sorted().forEach(System.out::println);
        arrayStream.sorted().forEach(System.out::println);

    }
}
