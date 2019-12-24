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

        System.out.println("===============");
        listStream.sorted().forEach(System.out::println);
        System.out.println("===============");
        arrayStream.sorted().forEach(System.out::println);
        System.out.println("===============");
        //스트림 특징
        //스트림은 일회용이다. 스트림은 한번 사용하면 닫혀서 다시 사용할수 없다.
        //listStream.sorted().forEach(System.out::println);
        // int numOfElement = listStream.count(); //스트림이 이미 닫힘

        //스트림의 연산
        Stream<String> stream = strList.stream();
        stream.distinct()
                .limit(5)
                .sorted()
                .forEach(System.out::println);
    }
}
