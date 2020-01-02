package java8.MethodRefrence;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MREx {
    Function<String, Integer> f = str -> Integer.parseInt(str);

    //정적 메서드 레퍼런스
    Function<String, Integer> f1 = Integer::parseInt;
    Integer result = f1.apply("123");

    //인자 인스턴스 메서드 래퍼런스
    Function<String, Boolean> f2 = String::isEmpty;
    Boolean result1 = f2.apply("123");

    //생성자 메서드 레퍼런스
    Supplier<String> s = String::new;

    //바깥 인스턴스 메서드 레퍼런스
    String str = "hello";
    Predicate<String> p = str::equals;

}
