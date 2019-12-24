package java8.stream;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

        //병렬 스트림
        Stream<String> strStream = strList.stream();
        int sum = strStream.parallel()
                .mapToInt(s -> s.length())
                .sum();
        System.out.println(sum);


        // 1.생성하기 : 스트림 인스턴스 생성
        // 2.가공하기 : 필터링 및 맵핑등 원하는 결과를 만들어가는 중간 작업
        // 3.결과 만들기 : 최종적으로 결과를 만들어내는 작업
        // 1. 저체 -> 맵핑 -> 필터링1 -> 필터링 2 -> 결과 만들기 -> 결과물

        //배열 스트림
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream2 = list.stream();
        Stream<String> parallelStream = list.parallelStream();

    }

    //컬렉션 스트림
    public interface Collection<E> extends Iterable<E> {
        default Stream<E> stream() {
            return StreamSupport.stream(spliterator(), false);
        }
    }

    //비어 있는 스트림
    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}
