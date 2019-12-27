package java8.stream;

import com.acompany.Product;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamEx {
    private static int counter;

    //지연 처리 Lazy Invocation
    private static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) throws IOException {

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

        //스트림 빌더
        Stream<String> build = Stream.<String>builder()
                .add("Eric").add("Elena").add("Java")
                .build();
        build.forEach(System.out::println);

        //Stream.generate()
        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5);
        generatedStream.forEach(System.out::println);

        //Stream.iterate()
        Stream<Integer> iteratedStream = Stream.iterate(20, n -> n + 2).limit(5);
        iteratedStream.forEach(System.out::println);

        //기본 타입형 스트림
        IntStream range = IntStream.range(1, 5);
        LongStream longStream = LongStream.rangeClosed(1, 5);
        range.forEach(System.out::print);
        System.out.println();
        longStream.forEach(System.out::print);

        //메소드를 이용해서 박싱
        Stream<Integer> boxed = IntStream.range(1, 5).boxed();
        boxed.forEach(System.out::print);

        //난수 방생
        DoubleStream doubles = new Random().doubles(3);
        doubles.forEach(System.out::print);

        //문자열 스트링
        IntStream chars = "Stream".chars();
        chars.forEach(System.out::print);
        System.out.println();

        //정규표현식 예제
        Stream<String> stream3 = Pattern.compile(", ").splitAsStream("Eric, Elena, java");
        stream3.forEach(System.out::print);
        System.out.println();
        //파일 스트림
        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\user\\IdeaProjects\\modernJava\\src\\java8\\stream\\file.txt"), Charset.forName("UTF-8"));

        //배열을 이용해서 병렬 스트림을 생성
        Stream<String> parallel = Arrays.stream(arr).parallel();

        //컬렉션과  배열이 아닌경우 병렬스트림 방법
        IntStream parallel1 = IntStream.range(1, 150).parallel();
        boolean parallel2 = parallel1.isParallel();
        System.out.println(parallel2);

        //스트림 연결하기
        Stream<String> stream4 = Stream.of("Java", "Scala", "Groovy");
        Stream<String> stream5 = Stream.of("Python", "Go", "Swift");
        Stream<String> concat = Stream.concat(stream4, stream5);
        concat.forEach(System.out::println);

        //가공하기
        List<String> names = Arrays.asList("Eric", "Elena", "java");

        //filtering
        Stream<String> stream6 = names.stream().filter(name -> name.contains("a"));
        stream6.forEach(System.out::println);

        //Mapping
        Stream<String> stream7 = names.stream().map(String::toUpperCase);
        stream7.forEach(System.out::println);

        //flatMap
        List<List<String>> lists = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        lists.forEach(System.out::println);

        //Sorting
        List<Integer> collect = IntStream.of(14, 11, 20, 39, 23)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
        lang.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(lang);

        lang.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        lang.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        lang.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .collect(Collectors.toList());

        sum = IntStream.of(1, 3, 5, 7, 9)
                .peek(System.out::println)
                .sum();
        System.out.println(sum);

        long count = IntStream.of(1, 3, 5, 7, 9).count();
        long sum1 = LongStream.of(1, 3, 5, 7, 9).sum();
        System.out.println(count);
        System.out.println(sum);

        OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
        OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
        System.out.println(min + " " + max);
        DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
                .average()
                .ifPresent(System.out::println);

        //Reduction
        int reduceTowparams = IntStream.range(1, 4)
                .reduce(10, Integer::sum);
        System.out.println(reduceTowparams);

        Integer combiner_was_called = Stream.of(1, 2, 3)
                .reduce(10,
                        Integer::sum, (a, b) -> {
                            System.out.println("combiner was called");
                            return a + b;
                        });
        System.out.println(combiner_was_called);

        Integer reduceParalle = Arrays.asList(1, 2, 3)
                .parallelStream()
                .reduce(10, Integer::sum, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });
        System.out.println(reduceParalle);

        //Collecting
        List<Product> productList1 = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));

        //Collectors.toList()
        List<String> collect1 = productList1.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(collect1);

        //Collectors.joining()
        String collect2 = productList1.stream()
                .map(Product::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect2);

        String collect3 = productList1.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ", "<", ">"));
        System.out.println(collect3);

        //Collectors.averageingInt()
        Double collect4 = productList1.stream()
                .collect(Collectors.averagingInt(Product::getAmount));
        System.out.println(collect4);

        //Collectors.summingInt()
        Integer collect5 = productList1.stream()
                .collect(Collectors.summingInt(Product::getAmount));
        System.out.println(collect5);

        int sum2 = productList1.stream()
                .mapToInt(Product::getAmount)
                .sum();
        System.out.println(sum2);

        //Collectors.summarizingInt()
        IntSummaryStatistics statistics = productList1.stream()
                .collect(Collectors.summarizingInt((Product::getAmount)));
        System.out.println(statistics);

        //Collectors.groupingBy()
        Map<Integer, List<Product>> collect6 = productList1.stream()
                .collect(Collectors.groupingBy(Product::getAmount));
        System.out.println(collect6);

        //Collectors.partitioningBy()
        Map<Boolean, List<Product>> collect7 = productList1.stream()
                .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));
        System.out.println(collect7);

        //Collectors.collectingAndThen()
        Object collect8 = productList1.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        System.out.println("collectingAndThen() : " + collect8);

        //Collector.of()
        Collector<Object, LinkedList<Object>, LinkedList<Object>> linkedListCollector = Collector.of(LinkedList::new, LinkedList::add, (first, second) -> {
            first.addAll(second);
            return first;
        });

        LinkedList<Object> collect9 = productList1.stream()
                .collect(linkedListCollector);
        System.out.println(collect9);

        //Matching
        List<String> names1 = Arrays.asList("Eric", "Elena", "Java");

        boolean anyMatch = names1.stream()
                .anyMatch(name -> name.contains("a"));
        boolean allMatch = names1.stream()
                .allMatch(name -> name.length() > 3);
        boolean noneMatch = names1.stream()
                .noneMatch(name -> name.endsWith("s"));
        names1.stream().forEach(System.out::println);
        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);

        Optional<String> first = list.stream()
                .filter(el -> {
                    System.out.println("filter() was called.");
                    return el.contains("a");
                })
                .map(el -> {
                    System.out.println("map() was called.");
                    return el.toUpperCase();
                })
                .findFirst();
        System.out.println(first);

        //스트림 재사용
        List<String> stream8 = Stream.of("Eric", "elena", "Java")
                .filter(name -> name.contains("a"))
                .collect(Collectors.toList());

        Optional<String> first1 = stream8.stream().findFirst();
        Optional<String> any = stream8.stream().findAny();

        counter = 0;
        Stream<String> stream9 = list.stream()
                .filter(el -> {
                    wasCalled();
                    return el.contains("a");
                });
        System.out.println(counter);

        list.stream().filter(el -> {
            wasCalled();
            return el.contains("a");
        }).collect(Collectors.toList());
        System.out.println(counter);

        //Null-safe 스트림 생성하기
        List<Integer> intList1 = Arrays.asList(1, 2, 3);
        List<String> strList1 = Arrays.asList("a", "b", "c");

        //Stream<Integer> tStream = collectionToStream(intList1);
        List<String> nullList = null;

/*        nullList.stream()
                .filter(str -> str.contains("a"))
                .map(String::length)
                .forEach(System.out::println);*/
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

    //스트림 제너레이터
    public static <T> Stream<T> generate(Supplier<T> s) {
        return null;
    }

    public<T> Stream<T> collectionToStream(Collection<T> collection) {
        return Optional.ofNullable(collection).map(Collection::stream).orElseGet(Stream::empty);
    }

}
